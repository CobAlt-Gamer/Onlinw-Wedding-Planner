// Add guest to the list
document.getElementById('guestForm').addEventListener('submit', function(e) {
    e.preventDefault();
    let phone = document.getElementById('phone').value;

    if (phone === "") {
        alert("Please enter a mobile number.");
    } else {
        let li = document.createElement("li");
        li.appendChild(document.createTextNode(phone));
        document.getElementById('guestList').appendChild(li);
        document.getElementById('phone').value = "";
    }
});

// Send invitation
document.getElementById('sendInvitation').addEventListener('click', function() {
    let selectedDestination = document.getElementById('destination').value;
    let guests = document.getElementById('guestList').getElementsByTagName('li');
    
    if (guests.length === 0) {
        alert("Please add some guests first.");
        return;
    }
    
    let guestNumbers = [];
    for (let i = 0; i < guests.length; i++) {
        guestNumbers.push(guests[i].textContent);
    }

    alert(`Invitations sent to: ${guestNumbers.join(', ')} for the ${selectedDestination}.`);
});
