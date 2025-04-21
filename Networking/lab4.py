from tkinter import *
from tkinter import messagebox



def okbtn():
    name = fNameEntry.get()

    program = clicked.get()

    selected_courses = []
    if CheckVar1.get():
        selected_courses.append(f"Programming 1: {ProgCB.cget('onvalue')}")
    if CheckVar2.get():
        selected_courses.append(f"Web Page Design: {WebDCB.cget('onvalue')}")
    if CheckVar3.get():
        selected_courses.append(f"Software Engineering: {softengCB.cget('onvalue')}")

    courses = ", ".join(selected_courses)

    messagebox.showinfo("Student Info", f"Name: {name}\nResidency: {var1.get()}\nProgram: {program}\nCourses: {courses}")

def reset():
    fNameEntry.delete(0, END)
    var1.set(0)
    clicked.set("Health")
    CheckVar1.set(0)
    CheckVar2.set(0)
    CheckVar3.set(0)

def exit():
    print("Called exit")
    root.destroy()

root = Tk()
root.geometry("600x300")
root.title("Centennial College ")

# Title Frame
titleFrame = Frame(root, background='green')
titleFrame.pack()

titleLbl = Label(titleFrame, text="ICET Student Survey", pady=20, background='green', )
titleLbl.pack()
titleLbl.configure(font=("Comic Sans MS", 20, "bold"))

# Full Name Frame
contentFrame = Frame(root, background='green', width=600, height=400)
contentFrame.grid_columnconfigure(1, weight=1)
contentFrame.pack()

fNameLbl = Label(contentFrame, text="Full name:", background='green', anchor="w",width=20)
fNameEntry = Entry(contentFrame, width=50)

resLbl = Label(contentFrame, text="Residency:", background='green', anchor="w",width=20)

var1 = StringVar()
var1.set("Domestic")
radio1 = Radiobutton(contentFrame, text="Domestic", variable=var1, value="dom", background='green', anchor="w")
radio2 = Radiobutton(contentFrame, text="International", variable=var1, value="intl", background='green', anchor="w")

options = [
    "Health",
    "Engineering",
    "Science",
    "Education",
    "Law",
    "Philosophy",
    "History"
]

clicked = StringVar()

# initial menu text
clicked.set("Health")

progLbl = Label(contentFrame, text="Program:", background='green', anchor="w",width=20)
drop = OptionMenu(contentFrame, clicked, *options)
drop.config(anchor="w")
coursesLbl = Label(contentFrame, text="Courses:", background='green', anchor="w",width=20)

CheckVar1 = StringVar()
CheckVar2 = StringVar()
CheckVar3 = StringVar()
ProgCB = Checkbutton(contentFrame, text="Programming 1", variable=CheckVar1, onvalue="COMP100", offvalue='', width=20, background='green', anchor="w")
WebDCB = Checkbutton(contentFrame, text="Web Page Design", variable=CheckVar2, onvalue="COMP213", offvalue='', width=20, background='green', anchor="w")
softengCB = Checkbutton(contentFrame, text="Software Engineering", variable=CheckVar3, onvalue="COMP120", offvalue='', width=20, background='green', anchor="w")





rstBtn = Button(contentFrame, text='Reset',width=20, padx=5, command=reset)
okBtn = Button(contentFrame, text='Ok', width=20, command=okbtn)
exitBtn = Button(contentFrame, text='Exit', width=20,padx=5, command=exit)





# Grid stuff
fNameLbl.grid(column=0, row=0)
fNameEntry.grid(column=1, row=0)
resLbl.grid(column=0, row=1)
# rads
radio1.grid(column=1, row=1, sticky="w")
radio2.grid(column=1, row=2, sticky="w")

# drop
progLbl.grid(column=0, row=3)
drop.grid(column=1, row=3,sticky="w")

# CheckBoxes
coursesLbl.grid(column=0, row=4)
ProgCB.grid(column=1, row=4, sticky="w")
WebDCB.grid(column=1, row=5, sticky="w")
softengCB.grid(column=1, row=6, sticky="w")

#buttons
rstBtn.grid(column=0,row=7)
okBtn.grid(column=1, row=7)
exitBtn.grid(column=2,row=7)


# Main window config
root.configure(background='green')
root.mainloop()
