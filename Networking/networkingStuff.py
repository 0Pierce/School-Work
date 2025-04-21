import poplib as pop
import getpass
from email.parser import Parser

SERVER = "smtp-mail.outlook.com"
USER_EMAIL="my email"
PASSWORD =getpass.getpass("Enter password: ")

pop = pop.POP3_SSL(SERVER)
pop.user(USER_EMAIL)
pop.pass_(PASSWORD)

resp, mails, octects = pop.list()

num_email = len(mails)

resp, lines, octects =pop.retr(num_email)

for i in lines:
    print(i)



msg_content = b'\r\n'.join(lines).decode('utf-8')