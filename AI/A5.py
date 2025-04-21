import matplotlib
matplotlib.use('Agg')

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import yfinance as yf
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense, Dropout
from sklearn.metrics import mean_squared_error
import math



#gets stock data
def fetch_stock_data(ticker='AAPL', start='2020-01-01', end='2025-01-01'):
    stock_data = yf.download(ticker, start=start, end=end)
    return stock_data['Close'].values.reshape(-1, 1)


#Preprocess data
def preprocess_data(data, look_back=60):
    scaler = MinMaxScaler(feature_range=(0, 1))
    scaled_data = scaler.fit_transform(data)

    X, y = [], []
    for i in range(look_back, len(scaled_data)):
        X.append(scaled_data[i - look_back:i, 0])
        y.append(scaled_data[i, 0])

    X, y = np.array(X), np.array(y)
    train_size = int(len(X) * 0.8)
    X_train, X_test = X[:train_size], X[train_size:]
    y_train, y_test = y[:train_size], y[train_size:]

    X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1], 1))
    X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], 1))

    return X_train, y_train, X_test, y_test, scaler



#Build the LSTM model
def build_lstm_model(look_back=60):
    model = Sequential()
    model.add(LSTM(units=50, return_sequences=True, input_shape=(look_back, 1)))
    model.add(Dropout(0.2))
    model.add(LSTM(units=50))
    model.add(Dropout(0.2))
    model.add(Dense(units=1))
    model.compile(optimizer='adam', loss='mean_squared_error')
    return model


#Train and eval
def train_and_evaluate():
    data = fetch_stock_data()
    X_train, y_train, X_test, y_test, scaler = preprocess_data(data)

    model = build_lstm_model()
    model.fit(X_train, y_train, epochs=20, batch_size=32, verbose=1)

    predicted = model.predict(X_test)
    predicted = scaler.inverse_transform(predicted)
    y_test_inv = scaler.inverse_transform([y_test])

    rmse = math.sqrt(mean_squared_error(y_test_inv.T, predicted))
    print(f"RMSE: {rmse}")

    #Save plot to local dir
    plt.figure(figsize=(10, 6))
    plt.plot(y_test_inv.T, label='Actual Prices')
    plt.plot(predicted, label='Predicted Prices')
    plt.title('Stock Price Prediction')
    plt.legend()
    plt.savefig('stock_prediction_plot.png')
    print("Plot saved as 'stock_prediction_plot.png'")


if __name__ == "__main__":
    train_and_evaluate()

# ==============Exercise 2==============
print("=========Exercise 2=========")
import numpy as np
import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense, Dropout
import urllib.request
from sklearn.model_selection import train_test_split


#preprocess text data
def fetch_book_data(url='https://www.gutenberg.org/files/74/74-0.txt'):
    response = urllib.request.urlopen(url)
    text = response.read().decode('utf-8')
    return text.lower()


def preprocess_text(text, seq_length=100):
    chars = sorted(list(set(text)))
    char_to_idx = {c: i for i, c in enumerate(chars)}
    idx_to_char = {i: c for i, c in enumerate(chars)}

    total_possible = len(text) - seq_length
    if total_possible <= 0:
        raise ValueError("Text is too short for the given sequence length.")

    #Use step=2 to get roughly half the dataset
    step = 2
    X_data, y_data = [], []
    for i in range(0, total_possible, step):
        seq_in = text[i:i + seq_length]
        seq_out = text[i + seq_length]
        X_data.append([char_to_idx[c] for c in seq_in])
        y_data.append(char_to_idx[seq_out])

    X = np.reshape(X_data, (len(X_data), seq_length, 1)) / float(len(chars))
    y = tf.keras.utils.to_categorical(y_data, num_classes=len(chars))

    print(f"Using {len(X_data)} sequences with step size {step}")
    return X, y, char_to_idx, idx_to_char, chars


#LSTM model
def build_text_lstm_model(seq_length, n_chars):
    model = Sequential()
    model.add(LSTM(128, input_shape=(seq_length, 1), return_sequences=True))
    model.add(Dropout(0.2))
    model.add(LSTM(128))
    model.add(Dropout(0.2))
    model.add(Dense(n_chars, activation='softmax'))
    model.compile(loss='categorical_crossentropy', optimizer='adam')
    return model


#Generate text with temperature sampling
def generate_text(model, seed, char_to_idx, idx_to_char, chars, length=200, temperature=0.8):
    seed_idx = [char_to_idx.get(c, 0) for c in seed.lower()[:100]]
    generated = ''

    for _ in range(length):
        x_pred = np.reshape(seed_idx, (1, len(seed_idx), 1)) / float(len(chars))
        prediction = model.predict(x_pred, verbose=0)[0]

        #Apply temperature sampling
        prediction = np.log(prediction + 1e-10) / temperature
        exp_preds = np.exp(prediction)
        prediction = exp_preds / np.sum(exp_preds)
        next_idx = np.random.choice(len(chars), p=prediction)
        next_char = idx_to_char[next_idx]

        generated += next_char
        seed_idx.append(next_idx)
        seed_idx = seed_idx[1:]

    return generated


#Train and eval for book
def train_and_generate_book():
    text = fetch_book_data()
    print(f"Full text length: {len(text)} characters")

    X, y, char_to_idx, idx_to_char, chars = preprocess_text(text, seq_length=100)

    #Split into train (50%) and test (50%)
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.5, random_state=42)
    print(f"Training on {len(X_train)} sequences, testing on {len(X_test)} sequences")

    model = build_text_lstm_model(seq_length=100, n_chars=len(chars))
    model.fit(X_train, y_train, epochs=20, batch_size=256, verbose=1)

    #Compute test perplexity
    test_loss = model.evaluate(X_test, y_test, verbose=0)
    perplexity = np.exp(test_loss)
    print(f"Test Perplexity: {perplexity:.2f}")

    #Generate text
    seed = text[:100]  # First 100 characters of the book
    generated_text = generate_text(model, seed, char_to_idx, idx_to_char, chars, length=200, temperature=0.8)
    print("\nGenerated Text (Tom Sawyer):\n", generated_text)



    return model, char_to_idx, idx_to_char, chars


#Train and evaluate for lyrics
def train_and_generate_lyrics():
    lyrics = """
    Started from the bottom now we're here
    Started from the bottom now my whole team here
    I got loyalty, got royalty inside my DNA
    This is my heritage, all I'm focused on
    """
    text = lyrics * 100  # Repeat to create sufficient data
    print(f"\nRepeated lyrics length: {len(text)} characters")

    X, y, char_to_idx, idx_to_char, chars = preprocess_text(text, seq_length=100)

    #Split into train (50%) and test (50%)
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.5, random_state=42)
    print(f"Training on {len(X_train)} sequences, testing on {len(X_test)} sequences")

    model = build_text_lstm_model(seq_length=100, n_chars=len(chars))
    model.fit(X_train, y_train, epochs=20, batch_size=256, verbose=1)

    #Ctest perplexity
    test_loss = model.evaluate(X_test, y_test, verbose=0)
    perplexity = np.exp(test_loss)
    print(f"Test Perplexity: {perplexity:.2f}")

    #Generate text
    seed = lyrics[:100]
    generated_text = generate_text(model, seed, char_to_idx, idx_to_char, chars, length=200, temperature=0.8)
    print("\nGenerated Lyrics (Drake):\n", generated_text)

    return model, char_to_idx, idx_to_char, chars


if __name__ == "__main__":
    print("Training and Generating for Tom Sawyer...")
    train_and_generate_book()
    print("\nTraining and Generating for Drake Lyrics...")
    train_and_generate_lyrics()