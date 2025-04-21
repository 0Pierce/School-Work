import socket
host = 'localhost'
port=1234
address =(host,port)
# client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# client_socket.connect(address)
# print(client_socket)
# print(f"client socket is connected to {host} on port {port}")
# client_socket.close()

client_udp = socket.socket(socket.AF.INET,socket.SOCK_DGRAM)
message = "hello"
client_udp.sendto(message.encode(),address)
data , r_addrs = client_udp.recvfrom(1024)
print(f"from server: {data.decode("utf-8")}")

