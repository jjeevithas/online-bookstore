function loadBooks() {

    const search = document.getElementById("search").value.toLowerCase();
    const category = document.getElementById("categoryFilter").value;

    fetch("/books?search=" + encodeURIComponent(search))
        .then(response => {

            if (!response.ok) {
                throw new Error("Failed to load books");
            }

            return response.json();
        })
        .then(books => {

            const container = document.getElementById("books");

            container.innerHTML = "";

           const filteredBooks = books.filter(book => {

    const matchesSearch =
        (book.title || "").toLowerCase().includes(search) ||
        (book.author || "").toLowerCase().includes(search);

    const matchesCategory =
        category === "" ||
        (book.category || "").trim().toLowerCase() ===
        category.trim().toLowerCase();

    return matchesSearch && matchesCategory;
});

            if (filteredBooks.length === 0) {

                container.innerHTML = "<p> No books found.</p>";

                return;
            }

            filteredBooks.forEach(book => {

                container.innerHTML += `

                    <div class="card">

                        <img
                            src="${book.imageUrl || 'https://via.placeholder.com/300x430?text=Book'}"
                            alt="${book.title}"
                            width="150"
                            onerror="this.onerror=null; this.src='https://via.placeholder.com/300x430?text=Book';"
                        >

                        <h3>${book.title}</h3>

                        <p>by ${book.author}</p>

                        <p>
                            Category: ${book.category || "Not specified"}
                        </p>

                        <div class="price">
                            ₹${Number(book.price).toFixed(2)}
                        </div>

                        <a class="primary"
                           href="/book-details.html?id=${book.id}">
                           View Details
                        </a>

                    </div>

                `;

            });

        })
        .catch(error => {

            console.error("Error loading books:", error);

            document.getElementById("books").innerHTML =
                "<p>Unable to load books.</p>";

        });

}

loadBooks();