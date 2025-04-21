import socket
host = 'localhost'
port = 12345
address = (host,port)
server_udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server_udp.bind(address)
data , r_addrs = server_udp.recvfrom(1024)
response = f'the udp server response: {data}'
server_udp.sendto(response.encode('utf-8',r_addrs))
