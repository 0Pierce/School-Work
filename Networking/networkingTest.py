import requests

#URL='https://www.python.org'
URL='https://www.google.com'
# res=requests.options(URL)
s=requests.Session()
s.get(URL)
#"http://127.0.0.1:5000/read_session"

#key value
# for k,v in s.cookies.get_dict().items():
#     print(f'{k}:{v}')

for i in range(5):
    r=s.get(URL)
    print(r.text)


# print(res.status_code)
# print(res.ok)
# print(res.headers)
# print(res.history)
# print(res.encoding)
# print(res.headers)
#print(res.content)