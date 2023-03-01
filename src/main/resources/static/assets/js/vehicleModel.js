$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/vehicle-model/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (vehicleModel, status) {
            $('#idEdit').val(vehicleModel.id);
            $('#descriptionEdit').val(vehicleModel.description);
            $('#detailsEdit').val(vehicleModel.details);


        });

        $('#editModal').modal('show');
    });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/vehicle-model/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});