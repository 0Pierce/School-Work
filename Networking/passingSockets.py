import socket



name = socket.gethostname()
ipadr = socket.gethostname()
print(name)
print(ipadr)

#remote ip adrs
remote_host = 'www.python.org'
r_ipadr = socket.gethostbyname(remote_host)
print(remote_host)
print(r_ipadr)


prot = 'tcp'
for port in [21,25,23,80,22]:
    print(port)
    print(socket.getservbyport(port))

print('')
print("Hexlify")
print('')
from binascii import hexlify
for ipadrss in ['127.0.0.1','192.168.2.1']:
    packed = socket.inet_aton(ipadrss)
    #Reverse of ^^^
    unpacked = socket.inet_ntoa(packed)
    hex = hexlify(packed).decode()
    print(hex)
    print(unpacked)


