const apiBase = "http://localhost:8080/api/persons";

document.getElementById("createForm").onsubmit = async function(e) {
    e.preventDefault();
    const form = e.target;
    const username = "admin";
    const password = "admin123";
    const basicAuth = "Basic " + btoa(username + ":" + password);
    console.log("Creating person with name: %s, id: %s, email: %s, mobileNo: %s",
        form.name.value, form.id.value, form.email.value, form.mobileNo.value);
    console.log("Using Basic Auth: %s", basicAuth);
    const data = {
        name: form.name.value,
        id: form.id.value,
        email: form.email.value,
        mobileNo: form.mobileNo.value
    };
    const res = await fetch(apiBase, {
        method: "POST",
        headers: { "Content-Type": "application/json", "Authorization": basicAuth },
        body: JSON.stringify(data)
    });
    const result = await res.json();
    document.getElementById("createResult").innerText = res.ok ? "Created: " + JSON.stringify(result) : "Error: " + JSON.stringify(result);
};

async function getPersonById() {
    const id = document.getElementById("getId").value;
    const username = "admin";
    const password = "admin123";
    const basicAuth = "Basic " + btoa(username + ":" + password);
    if (!id) return;
    const res = await fetch(`${apiBase}/${id}`, {
        headers: {
            "Authorization": basicAuth,
            "Content-Type": "application/json"
        }
    });
    const result = await res.json();
    document.getElementById("getResult").innerText = res.ok ? JSON.stringify(result) : "Error: " + JSON.stringify(result);
}

async function listAllPersons() {
    const res = await fetch(apiBase);
    const result = await res.json();
    document.getElementById("listResult").innerText = res.ok ? JSON.stringify(result, null, 2) : "Error: " + JSON.stringify(result);
}

async function deletePersonById() {
    const id = document.getElementById("deleteId").value;
    if (!id) return;
    const res = await fetch(`${apiBase}/${id}`, { method: "DELETE" });
    document.getElementById("deleteResult").innerText = res.ok ? "Deleted" : "Error: " + await res.text();
}