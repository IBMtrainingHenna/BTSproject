//-------------create Bug-----------
function saveBug() {
	function success(response) {
		alert("Created Bug!");
		return response.json();
	}
	function errorHandler(error) {
		alert("Creat Bug Failed!");
		console.log(error);
	}
	const createBug = document.getElementById('createBug');
	if (!createBug.checkValidity()) {
		alert('Please fill all the fields');
		return;
	}

	const promise = fetch('/bug', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			name: document.getElementById('name').value,
			projectId: document.getElementById('projectId').value,
			module: document.getElementById('module').value,
			buildVersion: document.getElementById('buildVersion').value,
			synopsis: document.getElementById('synopsis').value,
			product: document.getElementById('product').value,
			submittedOn: document.getElementById('submittedOn').valueAsDate,
			status: document.getElementById('status').value,
			type: document.getElementById('type').value,
			severity: document.getElementById('severity').value,
			priority: document.getElementById('priority').value,
			description: document.getElementById('description').value,
		})
	});
	promise.then(success);
	promise.then(function(data) {
		console.log(data);
	})
	promise.catch(errorHandler);
}

//---------GET bug-------------

function getBug() {
	let id = document.getElementById('bugId').value;
	const promise = fetch('/bug/' + id);
	promise.then(function(response) {
		return response.json();
	})
		.then(function(bug) {
			console.log(bug);
			const table = document.getElementById('bugTable');
			const row = document.createElement('tr');
			const projectIdColumn = document.createElement('td');
			const statusColumn = document.createElement('td');
			const priorityColumn = document.createElement('td');
			const typeColumn = document.createElement('td');
			const submittedOnColumn = document.createElement('td');

			projectIdColumn.append(bug.projectId);
			statusColumn.append(bug.status);
			priorityColumn.append(bug.priority);
			typeColumn.append(bug.type);
			submittedOnColumn.append(bug.submittedOn);

			row.appendChild(projectIdColumn);
			row.appendChild(statusColumn);
			row.appendChild(priorityColumn);
			row.appendChild(typeColumn);
			row.appendChild(submittedOnColumn);

			table.appendChild(row);
		})
}


//---------GET bugs-------------

function getBugs() {
	const promise = fetch('/bug');
	promise.then(function(response) {
		return response.json();
	})
		.then(function(bug) {
			console.log(bug);
			const table = document.getElementById('bugTable');
			
			const rows=table.children.length;
			for(let count=0; count<rows; count++){
				table.children[0].remove();
			}
			
			for (let index = 0; index < bug.length; index++) {
				console.log(bug[index]);
				const currentBug = bug[index];
				const row = document.createElement('tr');
				const projectIdColumn = document.createElement('td');
				const statusColumn = document.createElement('td');
				const priorityColumn = document.createElement('td');
				const typeColumn = document.createElement('td');
				const submittedOnColumn = document.createElement('td');

				projectIdColumn.append(currentBug.projectId);
				statusColumn.append(currentBug.status);
				priorityColumn.append(currentBug.priority);
				typeColumn.append(currentBug.type);
				submittedOnColumn.append(currentBug.submittedOn);

				row.appendChild(projectIdColumn);
				row.appendChild(statusColumn);
				row.appendChild(priorityColumn);
				row.appendChild(typeColumn);
				row.appendChild(submittedOnColumn);

				table.appendChild(row);
			}
		})
}


//-------------update Bug-------
function updateBug() {
	function success(response) {
		console.log(response.json());
		return response.json();
	}
	function errorHandler(error) {
		console.log(error);
	}

	const updateBug = document.getElementById('updateBug');
	//	if (!updateBug.checkValidity()) {
	//		alert('form is invalid');
	//		return;
	//	}

	let id1 = document.getElementById('id').value;

	const promise = fetch(('/bug/' + id1), {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			status: document.getElementById('bugStatus').value
		})
	});

	promise.then(success);
	promise.then(function(data) {
		console.log(data);
	})
	promise.catch(errorHandler);
}
