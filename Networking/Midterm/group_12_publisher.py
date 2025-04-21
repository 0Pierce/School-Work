import tkinter as tk
from random import random , randint
from tkinter import messagebox
from group_12_data_generator import DataGen
import paho.mqtt.client as mqtt
import argparse
class PublisherGUI:
    def __init__(self, root ,min_value, max_value, pattern_interval, amplitude, topic):
        self.root = root
        self.root.title("Publisher")
        self.root.geometry("600x400")
        self.topic = topic
        self.value_generator = DataGen(min_value, max_value, pattern_interval, amplitude)
        self.client = mqtt.Client()
        self.skip_mode = False
        self.skip_counter = 0
        self.client.connect("localhost", 1883, 60)
        self.setup_gui()

    def setup_gui(self):
        # Parameter inputs
        self.status_label = tk.Label(self.root, text="Status: Ready")
        self.status_label.pack()

        self.min_value_entry = tk.Entry(self.root)
        self.max_value_entry = tk.Entry(self.root)
        self.pattern_interval_entry = tk.Entry(self.root)
        self.amplitude_entry = tk.Entry(self.root)

        # Shows generated data
        self.generated_data_label = tk.Label(self.root, text="Generated Data: ")

        # Current parameters
        self.min_value_label = tk.Label(self.root, text="Min Value: ")
        self.max_value_label = tk.Label(self.root, text="Max Value: ")
        self.pattern_interval_label = tk.Label(self.root, text="Pattern Interval: ")
        self.amplitude_label = tk.Label(self.root, text="Amplitude: ")

        # Buttons
        self.update_params_button = tk.Button(self.root, text='Update Parameters', command=self.update_parameters)
        self.send_data_button = tk.Button(self.root, text='Send Data', command=self.send_data)

        # Packing widgets
        self.min_value_entry.pack()
        self.max_value_entry.pack()
        self.pattern_interval_entry.pack()
        self.amplitude_entry.pack()
        self.update_params_button.pack()
        self.send_data_button.pack()
        self.generated_data_label.pack()
        self.min_value_label.pack()
        self.max_value_label.pack()
        self.pattern_interval_label.pack()
        self.amplitude_label.pack()

    def update_parameters(self):
        min_value = int(self.min_value_entry.get())
        max_value = int(self.max_value_entry.get())
        pattern_interval = float(self.pattern_interval_entry.get())
        amplitude = float(self.amplitude_entry.get())
        self.value_generator.update_parameters(min_value, max_value, pattern_interval, amplitude)
        self.min_value_label.config(text=f"Min Value: {min_value}")
        self.max_value_label.config(text=f"Max Value: {max_value}")
        self.pattern_interval_label.config(text=f"Pattern Interval: {pattern_interval}")
        self.amplitude_label.config(text=f"Amplitude: {amplitude}")

    def should_send(self):
        missed_probability = 0.02
        return random() > missed_probability
    
    def send_data(self):
        if self.skip_mode:
            if self.skip_counter > 0:
                self.skip_counter -= 1
                self.status_label.config(text=f"Skipping transmissions! {self.skip_counter} left...")
                if self.skip_counter == 0:
                    self.skip_mode = False
                return

        if random() < 0.02: 
            self.skip_mode = True
            self.skip_counter = randint(5, 10)
            print(f"Skip mode for the next {self.skip_counter} messages.")
            return
        
        if self.should_send():
            value = self.value_generator.generate_value()
            packaged_data = self.value_generator.package_value(value)
            self.client.publish(self.topic, packaged_data)
            print(f"Data sent: {packaged_data}")
        else:
            print("Transmission skipped..........")
        
        value = self.value_generator.generate_value()
        package = self.value_generator.package_value(value)
        self.client.publish("test/topic", package)
        self.generated_data_label.config(text=f"Generated Data: {package}")
        self.client.loop()

       
    

if __name__ == "__main__":
    # using command line arguments when running the program
    parser = argparse.ArgumentParser(description='Execute publisher client ')
    parser.add_argument('--min_val', type=int, default=10, help='Minimum value for data generation')
    parser.add_argument('--max_val', type=int, default=50, help='Maximum value for data generation')
    parser.add_argument('--pattern_interval', type=float, default=10, help='Interval for the pattern')
    parser.add_argument('--amplitude', type=float, default=5, help='Amplitude of the sinusoidal pattern')
    parser.add_argument('--topic', type=str, default="test/topic", help='MQTT topic to publish data')

    args = parser.parse_args()

    root = tk.Tk()
    gui = PublisherGUI(root, args.min_val, args.max_val, args.pattern_interval, args.amplitude, args.topic)
    root.mainloop()
