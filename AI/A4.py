import tensorflow as tf
from tensorflow.keras import layers, models
import numpy as np
from sklearn import svm
from sklearn.metrics import accuracy_score

print("===============Exercise 1===============")
#Load/Preprocess the data
(x_train, y_train), (x_test, y_test) = tf.keras.datasets.mnist.load_data()
x_train = x_train.reshape(-1, 28, 28, 1).astype('float32') / 255.0
x_test = x_test.reshape(-1, 28, 28, 1).astype('float32') / 255.0
y_train_cat = tf.keras.utils.to_categorical(y_train, 10)
y_test_cat = tf.keras.utils.to_categorical(y_test, 10)

#CNN model
def create_cnn_model():
    model = models.Sequential([
        # Convolutional layer
        layers.Conv2D(32, (3, 3), activation='relu', input_shape=(28, 28, 1)),
        # Mean pooling layer
        layers.AveragePooling2D((2, 2)),
        # Flatten for dense layer
        layers.Flatten(),
        # Dense output layer
        layers.Dense(10, activation='softmax')
    ])
    return model

# Train CNN model
cnn_model = create_cnn_model()
cnn_model.compile(optimizer=tf.keras.optimizers.SGD(learning_rate=0.015, momentum=0.8),
                 loss='categorical_crossentropy',
                 metrics=['accuracy'])

# Train the model
history = cnn_model.fit(x_train, y_train_cat,
                       epochs=10,
                       batch_size=54,
                       validation_data=(x_test, y_test_cat))

# Evaluate CNN
cnn_test_loss, cnn_test_acc = cnn_model.evaluate(x_test, y_test_cat)
print(f"CNN Test accuracy: {cnn_test_acc:.4f}")

#SVM comparison
#Reshaping data for better SVM
x_train_svm = x_train.reshape(-1, 784)
x_test_svm = x_test.reshape(-1, 784)

#Training SVM
svm_model = svm.SVC(kernel='rbf')
svm_model.fit(x_train_svm[:10000], y_train[:10000])
svm_pred = svm_model.predict(x_test_svm)
svm_acc = accuracy_score(y_test, svm_pred)
print(f"SVM Test accuracy: {svm_acc:.4f}")


print("===============Exercise 2===============")
#===============Exercise 2===============

import tensorflow as tf
from tensorflow.keras import layers, models

#Load/preprocess CIFAR data
(x_train, y_train), (x_test, y_test) = tf.keras.datasets.cifar10.load_data()
x_train = x_train.astype('float32') / 255.0
x_test = x_test.astype('float32') / 255.0
y_train = tf.keras.utils.to_categorical(y_train, 10)
y_test = tf.keras.utils.to_categorical(y_test, 10)

#CNN model
def create_cifar_cnn():
    model = models.Sequential([
        layers.Conv2D(32, (3, 3), activation='relu', padding='same',
                     input_shape=(32, 32, 3)),
        layers.AveragePooling2D((2, 2)),
        layers.Conv2D(64, (3, 3), activation='relu', padding='same'),
        layers.AveragePooling2D((2, 2)),
        layers.Conv2D(64, (3, 3), activation='relu', padding='same'),
        layers.Flatten(),
        layers.Dense(64, activation='relu'),
        layers.Dense(10, activation='softmax')
    ])
    return model

#Create and train the model
model = create_cifar_cnn()
model.compile(optimizer=tf.keras.optimizers.SGD(learning_rate=0.01, momentum=0.9),
             loss='categorical_crossentropy',
             metrics=['accuracy'])

#Train the model
history = model.fit(x_train, y_train,
                   epochs=10,
                   batch_size=32,
                   validation_data=(x_test, y_test))

#Eval the model
test_loss, test_acc = model.evaluate(x_test, y_test)
print(f"CIFAR-10 Test accuracy: {test_acc:.4f}")