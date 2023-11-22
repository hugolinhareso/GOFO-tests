# gofo
<h3>1. Introduction</h3>
Our system is a booking system for football playgrounds. It serves the players and playground owners as well. An administrator oversees the overall operations of the system and ensures that no fraud takes place. Anyone can register himself on the system and create a profile. He can see the playgrounds near to him or in a specific area or all of them. 

<h3>2. The Motivation for This Project</h3>
Thursday night is a good day to play football with friends, right? You called your friends Zyad and Mina to call the gang and book two hours at any playground near to you. They searched more than one playground to find the best one that is the nearest, most affordable and of course available at the time you need.<br>
Zyad and Mina failed to do the booking, so they called Yusuf Usama and Ahmed Ali to help search in their areas. They all failed to find a booking at the needed hours because it is such a busy day. You all spent a lot of time, transportation cost and effort to go to all these playgrounds or call the owners. Frustrated with this scenario that happens often, the group got a brilliant idea. They decided to build a system for booking playing hours in football playgrounds. This is going to be a very cool application. The initial set of requirements they have is below.

<h3>3. Project Description</h3>
Our system is a booking system for football playgrounds. It serves the players and playground owners as well. An administrator oversees the overall operations of the system and ensures that no fraud takes place. Anyone can register himself on the system and create a profile. He can see the playgrounds near to him or in a specific area or all of them. 

<h4>3.1 Playground owner</h4>
This is the person who wants to register his playground. He first registers himself on the system and creates a profile like any user, with his name, ID and password, email, phone and default location. Then he requests registering a playground and adds its name, its location, its size, the available hours, the price per hour and the cancellation period. A playground is not active until approved by the administrator who may check if information given is true.

<h4>3.2 The administrator</h4>
The administrator has the right to delete a playground or suspend it. This is usually the case if the owner does some fraudulent activities like double booking or if the playground gets a lot of complaints from the players. Then the administrator can activate it again or delete it completely. 
The owner can set and change the hours available for booking for his playground. He can view his bookings. And he can check the money in his eWallet. 
An eWallet is an electronic payment system used to allow players to pay for the bookings they make and allow ground owners collect their money. It is externally connected with a service like Fawry that allows players to add money to their eWallet and ground owners to take the money from it. Any user can check the money in his eWallet or transfer some of it to another eWallet. Adding money to the eWallet happens outside the system boundary.


<h4>3.3 Player</h4>
This is a person who is interested in booking a playground. He registers with the system and creates a profile as described above. He can display the playgrounds near to him or in a specific location on specific dates. He can filter them by the hours and date he selects. He can book a time slot of 1 or more hours if available and not booked. Booking includes (1) Checking available grounds and time slots (2) Selecting the free time slot(s) he wants (3) Calculating the total price (4) Paying the amount from his eWallet to the eWallet of the owner (5) The system updates the status of the booked slot(s) so no one else can book it, and optionally (6) The player can send invitation to his team members via email. To make this last step easy, he can create his favorite team and store their names and emails. Then he can select the entire team at once to send emails to. A player can also cancel a booking if within the cancellation period. 

<!-- DOCUMENTACAO -->
## Documentação 📖
  
A documentação está disponível na Wiki do repositório, basta clicar no botão abaixo: 

<a href="https://github.com/hugolinhareso/GOFO-tests/wiki" target="_blank">
  <img alt="a" src="https://img.shields.io/badge/read-documentation-blue?style=for-the-badge">
</a>

***
