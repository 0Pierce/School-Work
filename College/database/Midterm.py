#Pierce Pokorny
import random

import requests


#Q1
def question1():
    multiple = 3
    start = 10
    #Not inclusive?
    end = 50
    sum = 0
    for i in range(start, end):
        if (i % multiple != 0):
            sum += i

    print(f"The sum of the integers from {start} to {end} excluding multiples of {multiple} is {sum}")



#Q2
def question2():

    file = open("wk07b_ques2.txt","r")
    lines = file.readlines()

    L_ids = []
    for name in lines:
        fName,lName = name.strip().split(" ")
        l_id = (fName[0] + lName)[:8].lower()
        L_ids.append(l_id)


    print(L_ids)

#Q3
def question3(strings):


    longer = strings[0]
    for str in strings:
        if len(str) > len(longer):
            longer = str
    return longer



#Q4
def question4(nums):
    #Set up the keys
    keyList = {i: 0 for i in range(10)}
    #Cycle through the parameter list
    for num in nums:
        lDigit = num % 10 #get the last digit
        keyList[lDigit] += 1
    return keyList



#Q5
def question5(n):
    nums = []


    for i in range(n + 1):
        if i == 0:
            nums.append(2)
        elif i == 1:
            nums.append(-1)
        elif i == 2:
            nums.append(1)
            # After 3 the incrementation doesnt involve negatives so
            # No need to write out all of the cases
        elif i == 3:
            nums.append(0)
        else:
            # Applying the rule
            # If n = 4 then we do (4-1=3 returns 0)0 + 1(4-2=2 returns 1)
            # So then 4 -> 1, this recursively continues for all numbers
            nums.append(nums[i - 1] + nums[i - 2])

    return nums[n]


class Player:

    def __init__(self, name, country, rate):
        self._name = name
        self._country = country
        self.rate = rate

    #Equal
    def __eq__(self, other):
        return self._name == other._name and self._country == other._country and self.rate == other.rate

    #Greater than
    def __gt__(self, other):
        return self.rate > other.rate

    #Less than
    def __lt__(self, other):
        return self.rate < other.rate

    #toString
    def __str__(self):
        return f"Name:{self._name}, Country:{self._country}, Rating:{self.rate}"

def question7():
    url = 'http://127.0.0.1:5000/ques6a'

    # Define the data to be sent in the request
    data = {
        'field1': 'value1',
        'field2': 'value2',
        'field3': 'value3'
    }

    # Send the 'GET' request with the specified data
    response = requests.get(url, params=data)

    # Check if the request was successful (status code 200)
    if response.status_code == 200:
        # Print the text part of the response
        print(f"Status code: {response.status_code}")
        print(response.text)

    else:
        # Print an error message if the request was not successful
        print(f"Error: {response.status_code}")


def question8():




    query2= "field1=value1&field2=value2&field3=value3"

    # Construct the URL
    url = 'http://127.0.0.1:5000/ques6a'


    response = requests.get(url, params=query2)
    json_response = response.json()
    print(json_response)
print("Question1")
question1()
print("Question2")
question2()
print("Question3")
print(question3("We going to the moon gentlemen".split()))

print("Question4")
rand = [random.randint(0, 100) for _ in range(20)]
print(question4(rand))
print(rand)

print("Question5")
for x in range(10):
    print(f'{x} -> {question5(x)}')

print("Question6")
def questionCall6():
    p1 = Player('Hou Yifan', 'China', 2664)
    p2 = Player('Ju Wenjun', 'China', 2584)
    p3 = Player('Humpy Koneru', 'India', 2580)
    print(p1)
    print(p2)
    print(p3)
    print(f'{p2._name} is {"equal" if p2 == p2 else "not equal"} to {p2._name}')
    print(f'{p2._name} is {"lower" if p2 < p1 else "not lower"} than {p1._name}')
    print(f'{p2._name} is {"greater" if p2 > p3 else "not greater"} than {p3._name}')

print("Question6")
questionCall6()
print("Question7")
question7()
print("Question8")
question8()
