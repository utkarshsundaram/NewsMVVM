# NewsMVVM
A sample app using MVVM architecture

#Model: 
This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables

#View: 
It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.

#ViewModel
It acts as a link between the Model and the ViewModel. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model

#Data Binding
Data Binding Library was introduced by Google in order to bind data directly in the xml layout

#Two Way Data Binding
Two-way Data Binding is a technique of binding your objects to your XML layouts such that the Object and the layout can both send data to each other.
In our case, the ViewModel can send data to the layout and also observe changes.
For this, we need a BindingAdapter and custom attribute defined in the XML.
The Binding Adapter would listen to changes in the attribute property.
