from tkinter import *
from tkinter import messagebox

#create root widget/main window
print("good")
def printGreet():
    Label(root,text="Fool.").pack()
    Label(root, text="It has awaken.").pack()
    greeting="Crazy? I was crazy once Locked me into  makes me crazy "+userEntry.get()
    Label(root,text=greeting).pack()
    Label(root, text=" ").pack()


def showpopup():

    messagebox.showinfo("Oh uh!")

root = Tk();
root.geometry("600x600")
root.title("Turn back ")

#create a label
firstlbl = Label(root,text="Hewwo", bd=5, padx=20, pady=20)
secondlbl = Label(root,text="Hewwo", bd=5, padx=20, pady=20, relief=SUNKEN).pack(anchor=S)

#insert data
userEntry = Entry(root,width=50)
userEntry.insert(0,"Enter your name")

#Button
firstButton = Button(root, text='Click me, I dare you.', bd=10, fg="blue", command=printGreet)
secBtn = Button(root,text="You've done it now", command=showpopup)

#Radio Buttons
var1 = IntVar()
radio1 = Radiobutton(root, text="Option1", variable = var1,value=1)
radio2 = Radiobutton(root, text="Option2", variable = var1,value=2)

#Frames
frame1 = LabelFrame(root,text="FRAME 1", pady=30 , padx=30)

#Checkboxes
var2 = StringVar()
check1 = Checkbutton(frame1,text="BOX", variable=var2, )
check1.deselect()



firstlbl.pack()
userEntry.pack()
radio1.pack()
radio2.pack()
check1.pack()
firstButton.pack()
secBtn.pack()
#crete main event loop? weird naming
root.mainloop()