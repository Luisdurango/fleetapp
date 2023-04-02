$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/vehicle-make/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (vehicleMake, status) {
            $('#idEdit').val(vehicleMake.id);
            $('#descriptionEdit').val(vehicleMake.description);
            $('#detailsEdit').val(vehicleMake.details);


        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/vehicle-make/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});