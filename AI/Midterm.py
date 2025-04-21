import pandas as pd
import numpy as np
from ucimlrepo import fetch_ucirepo
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.preprocessing import StandardScaler, OneHotEncoder
from sklearn.compose import ColumnTransformer
from sklearn.metrics import classification_report, confusion_matrix, accuracy_score

#Fetch dataset
heart_data = fetch_ucirepo(id=45)
X = heart_data.data.features
y = heart_data.data.targets
data = pd.concat([X, y], axis=1)

columns = ["age", "sex", "cp", "trestbps", "chol", "fbs", "restecg", "thalach",
           "exang", "oldpeak", "slope", "ca", "thal", "num"]
data = data[columns]

#Clean data
data.replace("?", np.nan, inplace=True)
data.dropna(inplace=True)
data = data.apply(pd.to_numeric)
data['num'] = data['num'].apply(lambda x: 1 if x > 0 else 0)

#Print dataset information
print("Cleaned dataset shape:", data.shape)
print("Sample of data:")
print(data.head(10))

#Features and target
X = data.drop("num", axis=1)
y = data["num"]

#Split data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

#Define columns
numerical_cols = ["age", "sex", "trestbps", "chol", "fbs", "thalach", "exang", "oldpeak", "slope", "ca"]
categorical_cols = ["cp", "restecg", "thal"]

#Preprocessor
preprocessor = ColumnTransformer(
    transformers=[
        ('num', StandardScaler(), numerical_cols),
        ('cat', OneHotEncoder(drop='first', handle_unknown='ignore'), categorical_cols)
    ]
)

#Transform data
preprocessor.fit(X_train)
X_train_transformed = preprocessor.transform(X_train)
X_test_transformed = preprocessor.transform(X_test)

#Train model
model = LogisticRegression(max_iter=1000)
model.fit(X_train_transformed, y_train)

#Eval
y_pred = model.predict(X_test_transformed)
print("Confusion Matrix:")
print(confusion_matrix(y_test, y_pred))
print("\nClassification Report:")  # Corrected label from "Classification:"
print(classification_report(y_test, y_pred))
print(f"Accuracy Score: {accuracy_score(y_test, y_pred):.2f}")

#New patient
new_patient_values = [[63, 1, 3, 145, 233, 1, 0, 150, 0, 2.3, 1, 0, 3]]
feature_names = ["age", "sex", "cp", "trestbps", "chol", "fbs", "restecg", "thalach",
                 "exang", "oldpeak", "slope", "ca", "thal"]
new_patient_df = pd.DataFrame(new_patient_values, columns=feature_names)
new_patient_transformed = preprocessor.transform(new_patient_df)
prediction = model.predict(new_patient_transformed)
print("\nPrediction for new patient:", "Heart Disease" if prediction[0] == 1 else "No Heart Disease Found, All good")