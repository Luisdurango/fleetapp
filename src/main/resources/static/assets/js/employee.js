$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('td:hidden').text(); // id not shown in the html page so .find is modified to match the closest 'tr' of the edit button in wich there is only 1 td hidden
        var url = '/employee/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (employee, status) {
            $('#id-edit').val(employee.id);
            $('#first-name-edit').val(employee.first_name);
            $('#last-name-edit').val(employee.last_name);
            $('#other-name-edit').val(employee.other_name);
            $('#title-edit').val(employee.title);
            $('#initials-edit').val(employee.initials);
            $('#social-security-edit').val(employee.social_security_number);
            $('#gender-edit').val(employee.gender);
            $('#marital-status-edit').val(employee.marital_status);
            $('#city-edit').val(employee.city);
            $('#adress-edit').val(employee.adress);
            $('#phone-edit').val(employee.phone);
            $('#mobile-edit').val(employee.mobile);
            $('#email-edit').val(employee.email);
            $('#photo-edit').val(employee.photo);
            $('#birthdate-edit').val(employee.birthDate);
            $('#country-edit').val(employee.countryid);
            $('#state-edit').val(employee.state);
            $('#job-title-edit').val(employee.jobTitle);
            $('#employee-type-edit').val(employee.employeeType);
            $('#hiredate-edit').val(employee.hireDate);
            $('#username-edit').val(employee.username);


        });

        $('#editModal').modal('show');
    });
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('td:hidden').text(); // get the id of the clicked row
        var url = '/employee/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (employee, status) {
            $('#id-details').val(employee.id);
            $('#first-name-details').val(employee.first_name);
            $('#last-name-details').val(employee.last_name);
            $('#other-name-details').val(employee.other_name);
            $('#title-details').val(employee.title);
            $('#initials-details').val(employee.initials);
            $('#social-security-details').val(employee.social_security_number);
            $('#gender-details').val(employee.gender);
            $('#marital-status-details').val(employee.marital_status);
            $('#city-details').val(employee.city);
            $('#adress-details').val(employee.address);
            $('#phone-details').val(employee.phone);
            $('#mobile-details').val(employee.mobile);
            $('#email-details').val(employee.email);
            $('#photo-details').val(employee.photo);
            var birthDate = new Date(employee.birthDate);
            var formattedBirthDate = birthDate.toLocaleDateString();
            $('#birthdate-details').val(formattedBirthDate);
            $('#country-details').val(employee.countryid);
            $('#state-details').val(employee.stateid);
            $('#job-title-details').val(employee.job_titleid);
            $('#employee-type-details').val(employee.employee_typeid);
            var hireDate = new Date(employee.hireDate);
            var formattedDate = hireDate.toLocaleDateString();
            $('#hiredate-details').val(formattedDate);
            $('#username-details').val(employee.username);


        });

        $('#detailsModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/employee/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });

    $('.table #photoButton').on('click',function(event) {
        event.preventDefault();
        //var href = $(this).attr('href');
        $('#employeePhoto').attr('src', $(this).attr('href'));
        $('#photoModal').modal('show');
    }); 
});