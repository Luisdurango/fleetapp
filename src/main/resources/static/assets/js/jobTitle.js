$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/job-title/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (jobTitle, status) {
            $('#idEdit').val(jobTitle.id);
            $('#descriptionEdit').val(jobTitle.description);
            $('#detailsEdit').val(jobTitle.details);


        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/job-title/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});