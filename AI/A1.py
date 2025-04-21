import pandas as pd
import numpy as np
from sklearn.metrics import mean_absolute_error, r2_score
from sklearn.datasets import fetch_california_housing
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import PolynomialFeatures, StandardScaler
from sklearn.linear_model import LinearRegression
from sklearn.pipeline import make_pipeline
from sklearn.metrics import mean_squared_error, r2_score

print("Exercise 1")
def load_data():
    df = pd.read_excel("C:/Users/pierc/Desktop/Code/Python/AI/realEstateData.xlsx", skiprows=1, names=[
        "No", "X1_trans_date", "X2_house_age", "X3_distance_to_mrt",
        "X4_num_convenience", "X5_latitude", "X6_longitude", "Y_price_per_unit"
    ])
    df.drop(columns=["No"], inplace=True)
    return df


def preprocess_data(df):
    X = df.drop(columns=["Y_price_per_unit"])
    y = df["Y_price_per_unit"]
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

    scaler = StandardScaler()
    X_train_scaled = scaler.fit_transform(X_train)
    X_test_scaled = scaler.transform(X_test)

    return X_train_scaled, X_test_scaled, y_train, y_test, scaler


def train_model(X_train, y_train):
    model = LinearRegression()
    model.fit(X_train, y_train)
    return model


def evaluate_model(model, X_test, y_test):
    y_pred = model.predict(X_test)
    mae = mean_absolute_error(y_test, y_pred)
    r2 = r2_score(y_test, y_pred)
    print(f"Model Eval:\nMean Absolute Error: {mae:.1f}\n Score: {r2:.1f}")


def predict_price(model, scaler):
    print("Enter property details:")
    trans_date = float(input("Transaction Date: "))
    house_age = float(input("House Age: "))
    distance_mrt = float(input("Distance to MRT: "))
    num_convenience = int(input("Number of Conv Stores: "))
    latitude = float(input("Lat: "))
    longitude = float(input("Long: "))

    input_data = pd.DataFrame([[trans_date, house_age, distance_mrt, num_convenience, latitude, longitude]],
                              columns=["X1_trans_date", "X2_house_age", "X3_distance_to_mrt",
                                       "X4_num_convenience", "X5_latitude", "X6_longitude"])

    input_data_scaled = scaler.transform(input_data)  # No more warning
    predicted_price = model.predict(input_data_scaled)
    print(f"Predicted price per Unit Area: {predicted_price[0]:.2f}")


if __name__ == "__main__":
    df = load_data()
    X_train, X_test, y_train, y_test, scaler = preprocess_data(df)
    model = train_model(X_train, y_train)
    evaluate_model(model, X_test, y_test)
    predict_price(model, scaler)




#EXERCISE 2
print("=======================")
print("Exercise 2")
def load_data():
    housing = fetch_california_housing()
    return housing.data, housing.target, housing.feature_names


def train_polynomial_regression(X, y, degree=2):
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    model = make_pipeline(StandardScaler(), PolynomialFeatures(degree), LinearRegression())
    model.fit(X_train, y_train)

    y_pred = model.predict(X_test)
    mse = mean_squared_error(y_test, y_pred)
    r2 = r2_score(y_test, y_pred)

    print(f"Trained model with degree of {degree}")
    print(f"Mean Square Error: {mse:.4f}")
    print(f"R-squared Score is: {r2:.4f}")

    return model



def predict_price(model, feature_names):
    print("Enter the models parameters:")
    user_input = []
    for feature in feature_names:
        value = float(input(f"{feature}: "))
        user_input.append(value)

    user_array = np.array(user_input).reshape(1, -1)
    predicted_price = model.predict(user_array)
    print(f"Predicted House Price is: ${predicted_price[0] * 100000:.2f}")


if __name__ == "__main__":
    X, y, feature_names = load_data()
    model = train_polynomial_regression(X, y, degree=3)
    predict_price(model, feature_names)
