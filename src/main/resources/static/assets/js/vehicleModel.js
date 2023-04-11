$('document').ready(function () {
    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/vehicle-model/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (vehicleModel, status) {
            $('#id-edit').val(vehicleModel.id);
            $('#description-edit').val(vehicleModel.description);
            $('#details-edit').val(vehicleModel.details);


        });

        $('#editModal').modal('show');
    });

    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/vehicle-model/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (vehicleModel, status) {
            $('#id-details').val(vehicleModel.id);
            $('#description-details').val(vehicleModel.description);
            $('#details-details').val(vehicleModel.details);
            $('#created-on').val(vehicleModel.createdDate.substring(0,10));
            $('#created-by').val(vehicleModel.createdBy);
            $('#last-modified-by').val(vehicleModel.lastModifiedBy);
            $('#last-modified-date').val(vehicleModel.lastModifiedDate.substring(0,10));


        });

        $('#detailsModal').modal('show');
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