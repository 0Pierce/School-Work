import paho.mqtt.client as mqtt

# def on_publish():
#     print('message sent')
#
# client = mqtt.Client()
# client.on_publish = on_publish
# client.connect('localhost', 1883)
# client.loop_start()
# client.publish('comp216','hellocomp216')
# client.loop_stop()



# import paho.mqtt.client as mqtt
# def on_message(client, userdata, message):
#     print(f'\n{message.topic} \n{message.payload.decode("utf-8")}\n')
# client = mqtt.Client() #instantiates a client
# client.connect('localhost', 1883)
# client.on_message = on_message #wire-up the on_message handlerclient.connect('localhost', 1883) #connects to the server
# client.subscribe('comp216') # topic to subscribe to
# while True:
#     client.loop_forever()


import paho.mqtt.client as mqtt
client = mqtt.Client()
client.connect('localhost',1883)
client.publish('comp216', payload='hellocomp216')
client.disconnect()