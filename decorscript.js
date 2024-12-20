// destination.js

// Get the URL parameters
const urlParams = new URLSearchParams(window.location.search);
const destination = urlParams.get('dest');

// Handle the destination info based on the URL parameter
const destinationInfo = document.getElementById('destination-info');
const bookingError = document.getElementById('booking-error');

const destinations = {
    paris: {
        name: 'Paris',
        description: 'Paris, the City of Love, is the perfect place to have a romantic wedding. Imagine saying your vows with the Eiffel Tower in the background.',
        image: 'paris.jpeg'
    },
    bali: {
        name: 'Bali',
        description: 'Bali offers lush beaches and scenic views, making it a dreamy place for a wedding surrounded by nature and culture.',
        image: 'bali.jpeg'
    },
    venice: {
        name: 'Venice',
        description: 'Venice is a timeless and elegant city with its canals and romantic ambiance. A wedding here will be a memorable and magical experience.',
        image: 'vience.jpeg'
    }
};

// Display the destination details
if (destinations[destination]) {
    const dest = destinations[destination];
    destinationInfo.innerHTML = `
        <div class="col-md-6">
            <img src="${dest.image}" alt="${dest.name}" class="img-fluid rounded">
        </div>
        <div class="col-md-6">
            <h2>${dest.name}</h2>
            <p>${dest.description}</p>
        </div>
    `;
} else {
    destinationInfo.innerHTML = `<p class="col-12">Destination not found!</p>`;
}

// Handle the booking form submission
document.getElementById('bookingForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const date = document.getElementById('date').value;

    if (!name || !email || !date) {
        bookingError.style.display = 'block';
    } else {
        bookingError.style.display = 'none';
        alert('Booking Successful! We will contact you soon.');
    }
});
