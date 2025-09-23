x = [[5, 2, 3], [10, 8, 9]]
students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'}
]
sports_directory = {
    'basketball': ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer': ['Messi', 'Ronaldo', 'Rooney']
}
z = [{'x': 10, 'y': 20}]

x[1][0] = 15
print(x)
print()
print("**************************************")

students[0]["last_name"] = "Bryant"
print(students)
print("**************************************")
print()

sports_directory["soccer"][0] = "Andres"
print(sports_directory)
print("**************************************")
print()

z[0]["y"] = 30

print(z)
print("**************************************")
print()

students = [
    {'first_name': 'Michael', 'last_name': 'Jordan'},
    {'first_name': 'John', 'last_name': 'Rosales'},
    {'first_name': 'Mark', 'last_name': 'Guillen'},
    {'first_name': 'KB', 'last_name': 'Tonel'}
]


def iterate_dictionary(some_list):
    for i in some_list:
        student = ""
        for key, value in i.items():
            student += f"{key} - {value}, "
        print(student[:-2])


def iterate_dictionary2(key_value, some_list):
    for i in some_list:
        for key, value in i.items():
            if key == key_value:
                print(f"{value}")


iterate_dictionary(students)
print("**************************************")
print()

iterate_dictionary2("last_name", students)
print("**************************************")
print()
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}


def print_info(some_dic):
    for key, value in some_dic.items():
        print(f"{len(value)} {str.upper(key)}")
        for item in value:
            print(f"{item}")
        print()


print_info(dojo)
