class Shopper():
    __prices = {'apple': 1.8, 'bread': 2.2, 'milk': 4.9, 'pepper': 1.2}
    __sale_items = ['apple', 'banana']
    __discount_threshold = 6
    __default_price = 2.5
    __volume_discount = 0.9
    __sales_discount = 0.85
    name = None

    def __init__(self, name, amount):
        self.name = name
        self.amount = amount
        self.purchases = []
        self.cash = amount

    @classmethod
    def price_list(cls):
        return cls.__prices

    @classmethod
    def sale_items(cls):
        return cls.__sale_items

    @classmethod
    def add_sale_item(cls, item):
        cls.__sale_items.append(item)

    def purchase(self, items=[]):
        total_cost = 0

        #print("Purchase")
        #print(items)
        prices = Shopper.price_list()
        cost = 0
        #print(prices)
        for item in items:
            if item.lower() in Shopper.sale_items():
                #print(prices.get(item.lower(), self.__default_price) * self.__sales_discount)
                cost = prices.get(item.lower(), self.__default_price) * self.__sales_discount
            else:
                #print(prices.get(item.lower(), self.__default_price))
                cost = prices.get(item.lower(), self.__default_price)

            total_cost += cost
            self.purchases.append((item, round(cost, 2)))

        if total_cost < self.amount:
            total_cost *= self.__volume_discount

        self.cash -= total_cost
        #print(self.purchases)
        #print(total_cost)

    def __str__(self):
        purchases_str = "\n  items:\n  []" if not self.purchases else "\n  items:\n  " + \
                        ', '.join([f"('{item}', {price})" for item, price in self.purchases])

        return f"{self.name} cash in hand ${self.cash:.2f}" + purchases_str


# Shopper = Shopper("Jeff", 15)
# Shopper.purchase("Apple Bread Peach".split())

print(f'Price dict: {Shopper.price_list()}')
print(f'Sales list: {Shopper.sale_items()}')

nar = Shopper('Narendra', 20)  # create a shopper object
print(f'\n{nar}')  # display the object

items = 'bread milk bread'.split()  # list of items to buy
print(f'\n{nar.name} is purchasing: {items}')
nar.purchase(items)  # volume discount
print(f'{nar}')  # display the object

ilia = Shopper('Ilia', 25)  # new shopper
items = 'banana milk'.split()  # one sale item
print(f'\n{ilia.name} is purchasing: {items}')
ilia.purchase(items)
print(f'{ilia}')  # display the object

Shopper.add_sale_item('pepper')  # add pepper to the sales items list

arben = Shopper('Arben', 15)  # new shopper
items = 'apple pepper cauliflower pepper'.split()  # cauliflower is not on the price list
print(f'\n{arben.name} is purchasing: {items}')
arben.purchase(items)
print(f'{arben}')  # display the object

# you don't need to understand the code below
# it is for verification purposes
members = [member for member in dir(Shopper) if not member.startswith('_')]
print(f'\nPublic members of the class: {members}')
properties = [member for member in members if not callable(getattr(Shopper, member))]
print(f'Public properties: {properties}')
methods = [member for member in members if callable(getattr(Shopper, member))]
print(f'Public methods: {methods}')
