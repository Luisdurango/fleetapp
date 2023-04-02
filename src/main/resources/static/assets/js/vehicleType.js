$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/vehicle-type/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (vehicleType, status) {
            $('#idEdit').val(vehicleType.id);
            $('#descriptionEdit').val(vehicleType.description);
            $('#detailsEdit').val(vehicleType.details);


        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/vehicle-type/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});