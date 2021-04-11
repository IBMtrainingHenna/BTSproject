function saveBug() {
    function success(response) {
        return response.json();
    }
    function errorHandler(error) {
        console.log(error);
    }
    const createBug = document.getElementById('createBug');

    if (!createBug.checkValidity()) {
        alert('form is invalid');
        return;
    }
    const promise = fetch('/bug', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
       		name:document.getElementById('name').value,
            projectId: document.getElementById('projectId').value,
            module: document.getElementById('module').value,
            buildVersion: document.getElementById('buildVersion').value,
            synopsis: document.getElementById('synopsis').value,
            product: document.getElementById('product').value,
            submittedOn: document.getElementById('submittedOn').valueAsDate,
            priority: document.getElementById('priority').value,
            status: document.getElementById('status').value,
            severity:document.getElementById('severity').value,
            type: document.getElementById('type').value,
            description: document.getElementById('description').value,
        })
    });
    promise.then(success);
    promise.then(function (data) {
        console.log(data);
    })
    promise.catch(errorHandler);

}
