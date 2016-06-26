Person person = new Person();

//Assume this is local data called from getters
person.Name = “Ricky Bobby”;
person.Birthday = new DateTime(1987, 11, 12);
person.Phone = 5745558878;
person.Likes = new string[] {“Outdoors”, Dancing”, “Games”}

string output = JsonConvert.SerailizeObject(person);

//What the string should contain after being seralized
//{
//  “Name”: “Ricky Bobby”,
//  “Birthday”: “1987-11-12T00:00:00”,
//  “Phone”: 5745558878,
//  “Likes”: [
//    “Outdoors”,
//    “Dancing”,
//    “Games”
//  ]
//}

//Reversed the serialzation back into its object
Person deserializedProduct = JsonConvert.DeserializeObject<Person>(output);
