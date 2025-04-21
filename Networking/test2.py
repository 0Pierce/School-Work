import random
import matplotlib.pyplot as plt
import numpy as np


class data_Generator:
    class data_Generator:

        def __init__(self, scale=1, min_val=0, max_val=10, mu=0.5, sigma=0.1, base=0.4, delta=0.04, cycle=4):
            self.min_val = min_val
            self.max_val = max_val
            self.scale = scale
            self.dataAmount = 500
            self.mu = mu
            self.sigma = sigma
            self.base = base
            self.delta = delta
            self.cycle = cycle

        def generator_4(self) -> float:
            self.cycle -= 1
            if self.cycle == 0:
                self.cycle = random.randint(50, 100)  # Randomize cycle length
                self.delta *= -1  # Reverse the direction of change
            self.base += self.delta
            return self.base

        def generator_3(self) -> float:
            return random.gauss(self.mu, self.sigma)

        def generator_2(self) -> float:
            return random.uniform(self.min_val, self.max_val)

        def normalized_val(self) -> float:
            print(random.random())
            return random.random()

        def generator(self):

            x_data = [i * self.scale / self.dataAmount for i in range(self.dataAmount)]


            y_data = [(self.generator_4() + self.generator_3() + self.generator_2() )*self.normalized_val() for _ in range(self.dataAmount)]


            y_data_scaled = [
                (val - min(y_data)) * (self.max_val - self.min_val) / (max(y_data) - min(y_data)) + self.min_val for val in y_data]

            plt.plot(x_data, y_data_scaled, 'b+')
            plt.plot(x_data, y_data_scaled, 'r-', alpha=0.4)
            plt.xlabel('Time (Daily)')
            plt.ylabel('Temperature (C)')
            plt.title('Outside Avg Summer Temperature Trend')
            plt.show()

    obj = data_Generator(scale=12, min_val=19.6, max_val=30)
    obj.generator()
