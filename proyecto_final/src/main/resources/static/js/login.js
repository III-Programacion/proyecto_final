document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");

    form.addEventListener("submit", () => {
        const username = document.getElementById("username").value;
        console.log("Intentando login con usuario:", username);
    });
});
