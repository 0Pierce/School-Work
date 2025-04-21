import random
import matplotlib.pyplot as plt


class DataGenerator:
    def __init__(self, min_val=19.6, max_val=30, scale=12, data_amount=500):
        self.min_val = min_val
        self.max_val = max_val
        self.scale = scale
        self.data_amount = data_amount
        self.i = 0

    def generator(self, choice="uniform"):
        if choice == "uniform":
            return random.uniform(self.min_val + 2, self.max_val - 2)
        elif choice == "gaussian":
            mu = (self.min_val + self.max_val) /2
            sigma = (self.max_val - self.min_val) / 6
            return random.gauss(mu, sigma)
        elif choice == "const":
            self.i+=0.1
            print(self.i)
            return 1.0 * self.i

    @property
    def generate_data(self):
        x_data = [i * self.scale / self.data_amount for i in range(self.data_amount)]
        y_data_uniform = [min(max(self.generator("uniform"), self.min_val), self.max_val) * 0.3 for _ in range(self.data_amount)]
        y_data_gaussian = [min(max(self.generator("gaussian"), self.min_val), self.max_val) * 0.3 for _ in range(self.data_amount)]
        y_data_const = [min(max(self.generator("const"), self.min_val), self.max_val) * 0.4 for _ in range(self.data_amount)]
        y_data_combined = [min(max(y_data_uniform[i] + y_data_gaussian[i] + y_data_const[i], self.min_val), self.max_val) for i in range(self.data_amount)]
        return x_data, y_data_combined

    def plot_data(self, x_data, y_data):
        plt.plot(x_data, y_data, 'b+')
        plt.plot(x_data, y_data, 'r-', alpha=0.4)
        plt.xlabel('Time (Daily)')
        plt.ylabel('Temperature (C)')
        plt.title('Outside Avg Summer Temperature Trend')
        plt.show()


# Example usage
obj = DataGenerator(min_val=19.6, max_val=28, scale=30)
x_data, y_data = obj.generate_data
obj.plot_data(x_data, y_data)
