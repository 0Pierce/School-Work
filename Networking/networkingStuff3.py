import imaplib
import email, email.header
import getpass

SERVER = "imap-mail.outlook.com"
USER_EMAIL="my email"
PASSWORD =getpass.getpass("Enter password: ")
EMAIL_FOLDER = "INBOX"




with imaplib.IMAP4_SSL(SERVER) as imap:
    imap.login(USER_EMAIL,PASSWORD)
    imap.select(EMAIL_FOLDER)
    rv, data = imap.search(None,'ALL')



for msg_num in data[0].split():
    rv, msg_raw = imap.fetch(msg_num,'(RFC822)')
    msg = email.message_from_bytes(msg_raw[0][1])
    hdr = email.header.make_header(email.header.decode_header(msg['Subject']))
    print(f'Message num: {msg_num}')
    print(f'subject : {str(hdr)}')
    print(f'date: {msg['Date']}')