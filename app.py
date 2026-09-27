import streamlit as st

st.set_page_config(
    page_title="Online Bookstore",
    page_icon="📚",
    layout="wide"
)

books = [
    {
        "title": "The Alchemist",
        "author": "Paulo Coelho",
        "category": "Fiction",
        "price": 299
    },
    {
        "title": "Atomic Habits",
        "author": "James Clear",
        "category": "Self Help",
        "price": 399
    },
    {
        "title": "Clean Code",
        "author": "Robert C. Martin",
        "category": "Technology",
        "price": 499
    },
    {
        "title": "Rich Dad Poor Dad",
        "author": "Robert Kiyosaki",
        "category": "Business",
        "price": 349
    },
    {
        "title": "The Pragmatic Programmer",
        "author": "Andrew Hunt",
        "category": "Technology",
        "price": 549
    }
]

st.title("📚 Online Bookstore")
st.write("Explore books by category and search for your favourite book.")

search = st.text_input("🔍 Search books")

categories = ["All Categories"] + sorted(
    set(book["category"] for book in books)
)

category = st.selectbox("📂 Select Category", categories)

filtered_books = books

if search:
    filtered_books = [
        book for book in filtered_books
        if search.lower() in book["title"].lower()
        or search.lower() in book["author"].lower()
    ]

if category != "All Categories":
    filtered_books = [
        book for book in filtered_books
        if book["category"] == category
    ]

st.subheader("Available Books")

for book in filtered_books:
    with st.container(border=True):
        st.subheader(book["title"])
        st.write(f"**Author:** {book['author']}")
        st.write(f"**Category:** {book['category']}")
        st.write(f"**Price:** ₹{book['price']}")
        st.button(
            "🛒 Add to Cart",
            key=book["title"]
        )