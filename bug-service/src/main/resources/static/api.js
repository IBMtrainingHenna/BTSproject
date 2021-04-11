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
            description: document.getElementById('description').value,
            status: document.getElementById('status').value,
            priority: document.getElementById('priority').value,
            type: document.getElementById('type').value,
            submittedOn: document.getElementById('submittedOn').valueAsDate,
            buildVersion: document.getElementById('buildVersion').value,
            projectId: document.getElementById('projectId').value,
            module: document.getElementById('module').value,
            product: document.getElementById('product').value,
            severity:document.getElementById('severity').value
        })
    });
    promise.then(success);
    promise.then(function (data) {
        console.log(data);
    })
    promise.catch(errorHandler);

}