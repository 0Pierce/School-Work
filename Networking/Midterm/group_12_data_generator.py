import random
import json
import time
import math
import paho.mqtt.client as mqtt


class DataGen:
    def __init__(self, min_value, max_value, pattern_interval, amplitude, device_id=math.floor(random.random()*10)):
        self.min_value = min_value
        self.max_value = max_value
        self.pattern_interval = pattern_interval
        self.amplitude = amplitude
        self.device_id = device_id


    def update_parameters(self, min_value, max_value, pattern_interval, amplitude):
        self.min_value = min_value
        self.max_value = max_value
        self.pattern_interval = pattern_interval
        self.amplitude = amplitude

    def generate_value(self):
        value = random.randint(self.min_value, self.max_value)
        pattern_value = self.amplitude * \
            math.sin(time.time() / self.pattern_interval)
        new_value = value + pattern_value
        if time.time() % self.pattern_interval == 0:
            value += 1
        return value

    def package_value(self, value):
        package = {
            "timestamp": time.time(),
            "packet_id": random.randint(1000, 9999),
            "value": value,
            "device_id": self.device_id,
        }
        return json.dumps(package)
    def generate_wild_data(self):
        if random.choice([True, False]):
            return random.randint(5 * self.max_value, 10 * self.max_value)
        else:
            return random.randint(-10 * self.min_value, -5 * self.min_value) 
