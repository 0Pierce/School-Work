from typing import Dict


#Jons original
# def find_word(board, word):
#     i = 0
#     list_of_positions = []
#     for line in board:
#         j = 0
#         print("First nested loop")
#         for letter in line:
#             print(line)
#             #Stuck
#
#             if len(list_of_positions) == len(word):
#                 print("Returned")
#                 print(list_of_positions)
#                 return list_of_positions
#
#             if word[0] == letter:
#                 list_of_positions.append((i,j))
#                 new_board = []
#                 print("Second loop")
#                 for line in example_board[max(0,i-1):i+2]:
#                     print(line)
#                     new_line = []
#                     for letter in line[max(0,j-1):j+2]:
#                         new_line.append(letter)
#                     new_board.append(new_line)
#                 print("Returned pos")
#                 list_of_positions = find_word(new_board, word[1:])
#             j += 1
#         i += 1
#
#     list_of_positions = []
#     return None


#find_word(example_board, "boy")



#Without recursion
def find_wordTest2(board, word):
    wordArr = [*word]
    row = 0
    target = []
    size = 0
    for line in board:
        print(line)
        row+=1
        #wordArr = hold the paramter string characters
        for char in wordArr:
            print(char)
            #print(f"{len(target) } {len(word)}")
            #print(f"{len(target) < len(word)} ")

            #Checks if the char is contained within the line, and while the size of the target(the word were finding) is smaller than the word we were given
            if line.__contains__(char.capitalize()) and size < len(word):


                print(f"Found: '{char}' at ({row},{line.index(char.capitalize())})")
                temp = line.index(char.capitalize())+1
                print(f"Out of bounds? {temp}")
                #print(f"Char at: {line.index(char.capitalize())}")
                target.append(char.lower())
                #print(char)
                #print(wordArr[wordArr.index(char)+1])
                #print(f"Current char index: {wordArr[line.index(char.capitalize())]}")
                #print(temp < len(line))
                #print(f"{line[temp]} =? {wordArr[wordArr.index(char)+1].capitalize()}")

                #Checks the right side of the found character if that character is the next in line
                if temp < len(line) and len(wordArr) > 1 and line[temp] == wordArr[wordArr.index(char)+1].capitalize():
                    print("Found next")
                    target.append(line[temp].lower())
                    print(f"Found: '{wordArr[wordArr.index(char)+1]}' at ({row},{temp})")
                    #print(f"List: {wordArr}")
                    wordArr.remove(wordArr[wordArr.index(char)+1])
                    #print(wordArr[wordArr.index(char)+2])

                    if temp+1 < len(line):

                        print(f"Temp: {line[temp + 1]}")
                        print(f"Before crash: {wordArr}")
                        print(f"Checking: {wordArr[wordArr.index(char)+1]}")
                        #print(line[temp + 1])
                        if wordArr[wordArr.index(char)+1].capitalize() == line[temp + 1]:
                            print(f"Found: '{wordArr[wordArr.index(char) +1]}' at ({row},{temp + 1})")
                            target.append(line[temp + 1].lower())



                #line.remove(char.capitalize())
                #print(f"Deleted: {line}")

                wordArr.remove(char)
                size+=1



            else:
                print("not found")
                print("")

    print("Found:")
    print(target)





def __init__():

    test = TrieDictionary()
    test.load_dictionary('dictionary.txt')
    test.print_words()




def find_word_Proper(board, word):


    #trie.print_words()

    charList = [*word]
    for line in board:
        print(line)

        for char in charList:
            print(char)














class TrieNode:

    def init(self):
        self.children : Dict[str, TrieNode] = {} # maps a child letter to its TrieNode class
        self.is_word = False # whether or not this Node is a valid word ending


class TrieDictionary():
    """
    Your implementation of BoggleDictionary.
    Several functions have been filled in for you from our solution, but you are free to change their implementations.
    Do NOT change the name of self.root, as our autograder will manually traverse using self.root
    """

    def init(self):
        self.root : TrieNode = TrieNode()

    def load_dictionary(self, filename: str) -> None:
        # Remember to add every word to the trie, not just the words over some length.
        with open(filename) as wordsfile:
            for line in wordsfile:
                word = line.strip().lower()
                node = self.root
                for letter in word:
                    if letter not in node.children:
                        node.children[letter] = TrieNode()
                        node = node.children[letter]
                    else:
                        node = node.children[letter]
                node.is_word = True
                # Do something with word here
        #raise NotImplementedError("method load_dictionary") # TODO: implement your code here

    def traverse(self, prefix: str):# -> Optional[TrieNode]:
        """
        Traverse will traverse the Trie down a given path of letters prefix.
        If there is ever a missing child node, then returns None.
        Otherwise, returns the TrieNode referenced by prefix.
        """
        node = self.root
        for letter in prefix.lower():
            if letter not in node.children:
                return None
            else:
                node = node.children[letter]
        return node

    # raise NotImplementedError("method traverse") # TODO: implement your code here

    def is_prefix(self, prefix: str) -> bool:

        if self.traverse(prefix.lower()):
            return True
        else:
            return False

        # raise NotImplementedError("method is_prefix") # TODO: implement your code here

    def contains(self, word: str) -> bool:

        node = self.traverse(word.lower())
        if node is None:
            return False
        else:
            return node.is_word

    def print_words(self):
        """
        Print all words stored in the trie.
        """
        self._print_words_helper(self.root, "")

    def _print_words_helper(self, node, prefix):
        if node.is_word:
            print(prefix)
        for letter, child_node in node.children.items():
            self._print_words_helper(child_node, prefix + letter)











row = 0
target = []
size = 0

#With recursion
def find_wordTestRecursion(board, word):
    wordArr = [*word]


    if len(wordArr) < len(word):
        print("=============Smaller============")
    #print("With recursion")
    for line in board:
        print(f"Print line: {line}")
        global row

        global target
        global size
        row+=1
        flag = False
        count = size + len(word)

        print(wordArr)
        if(len(wordArr)!= 0):
            char = wordArr[0]
        else:
            print("Broke, no char")
            break

        #print(f"WordArr: {wordArr}")
        print(f"Char: {char}")
        #print(f"{len(target) } {len(word)}")
        #print(f"{len(target) < len(word)} ")

        print(f"Does Size equal word??: {size <= len(word)} | Size: {size}, word: {count}")

        if line.__contains__(char.capitalize())  and flag == False and size <= count:
            flag = True
            print("First find")
            print(f"Found: '{char}' at ({row-1},{line.index(char.capitalize())})")
            temp = line.index(char.capitalize())+1
            #print(f"Out of bounds? {temp}")
            #print(f"Char at: {line.index(char.capitalize())}")
            target.append(char.lower())
            #print(char)
            #print(wordArr[wordArr.index(char)+1])
            #print(f"Current char index: {wordArr[line.index(char.capitalize())]}")
            #print(temp < len(line))
            #print(f"{line[temp]} =? {wordArr[wordArr.index(char)+1].capitalize()}")
            if temp < len(line) and len(wordArr) > 1 and line[temp] == wordArr[wordArr.index(char)+1].capitalize():
                #print("Found next")
                target.append(line[temp].lower())
                print(f"Found: '{wordArr[wordArr.index(char)+1]}' at ({row-1},{temp})")
                #print(f"List: {wordArr}")
                wordArr.remove(wordArr[wordArr.index(char)+1])
                #print(wordArr[wordArr.index(char)+2])



                if temp+1 < len(line):

                    print(f"Temp: {line[temp + 1]}")
                    print(f"Before crash: {wordArr}")
                    print(f"Checking: {wordArr[wordArr.index(char)+1]}")
                    #print(line[temp + 1])
                    if wordArr[wordArr.index(char)+1].capitalize() == line[temp + 1]:
                        print(f"Found: '{wordArr[wordArr.index(char) +1]}' at ({row-1},{temp + 1})")
                        target.append(line[temp + 1].lower())



            #line.remove(char.capitalize())

            wordArr.remove(char)
            newWord = ''.join(wordArr)

            size+=1
            board.remove(line)
            return find_wordTestRecursion(board,newWord)


        else:
            print("not found")
            print("")
            board.remove(line)
            print(f"Deleted: {line}")
            return find_wordTestRecursion(board, word)
            print(f"IS LINE EMPTY???: {line}")
            #line.remove()
            break

    print("Found Target:")
    print(target)
    return True





example_board = [
    ['E', 'E', 'C', 'A'],
    ['Z', 'L', 'E', 'P'],
    ['H', 'N', 'B', 'O'],
    ['Q', 'T', 'T', 'Y']
]


#print(find_wordTestRecursion(example_board, "nbe"))
#print(find_wordTest2(example_board, "ace"))

print(find_word_Proper(example_board, "ace"))



