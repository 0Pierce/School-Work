import tkinter as tk
import paho.mqtt.client as mqtt
from tkinter import messagebox, scrolledtext
import json


class SubscriberGUI:
    def __init__(self, root, topic="test/topic"):
        self.root = root
        self.topic = topic 
        self.root.title("Subscriber")
        self.client = mqtt.Client()
        self.client.on_connect = self.on_connect
        self.client.on_message = self.on_message
        self.client.connect("localhost", 1883, 60)
        self.client.subscribe("test/topic")
        self.client.loop_start()
        self.setup_gui()

    def on_connect(self, client, userdata, flags, rc):
        client.subscribe("test/topic")
        print("Connected with result code "+str(rc))

    
    def is_data_complete(self, data):
       
        required_fields = ['value', 'timestamp']
        missing_fields = [field for field in required_fields if field not in data]
        if missing_fields:
            error_message = f"Missing fields: {', '.join(missing_fields)}"
            self.text_area.insert(tk.END, error_message + "\n")
            return False
        return True
    # Process data  
    def on_message(self, client, userdata, msg):
  
        payload = msg.payload.decode('utf-8')

        print(f"Received message: {payload} on topic: {msg.topic}")

        try:
            data = json.loads(payload)
            if self.is_data_complete(data):
                self.handle_value(data.get('value', 0))
            else:
                display_txt = "Error: Missing data in received message.\n"
                messagebox.showwarning("Data Error", "Missing important data fields.")
                self.text_area.insert(tk.END, display_txt)
            if 'value' in data:
                val = data['value']
                display_txt = f"Received value: {val}\n"
                self.handle_value(val)
            else:
                display_txt = "Received data does not contain any value data\n"
                display_txt = f"Received: {data}\n" 

        except json.JSONDecodeError:
            display_txt = f"Received (non-JSON): {payload}\n"
        print(f"Received data: {msg}")

        self.text_area.insert(tk.END, display_txt)
        self.text_area.see(tk.END) 
    def handle_value(self, val):
        lower_limit = 0
        upper_limit = 100 
        if val < lower_limit or val > upper_limit:
            message = f"Alert: Value {val} is out of range ({lower_limit}-{upper_limit})."
            messagebox.showwarning("Value Out of Range", message)  # This will show a warning dialog box
            self.text_area.insert(tk.END, message + "\n")
        else:
            message = f"Received value within acceptable range: {val}"
            self.text_area.insert(tk.END, message + "\n")

        self.text_area.see(tk.END)
    # Do GUI stuff here
    def setup_gui(self):
        self.text_area = scrolledtext.ScrolledText(
            self.root, height=10, width=50, wrap=tk.WORD)
        self.text_area.pack(pady=20, padx=20)



if __name__ == "__main__":
    root = tk.Tk()
    gui = SubscriberGUI(root)
    frm = tk.Frame(root)
    frm.pack(side=tk.LEFT, expand=True, fill=tk.BOTH)
    
    frm2 = tk.Frame(root)
    frm2.pack(side=tk.LEFT, expand=True, fill=tk.BOTH)

    root.mainloop()
