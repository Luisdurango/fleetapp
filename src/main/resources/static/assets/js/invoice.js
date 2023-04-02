$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();

        var id = $(this).closest('tr').find('th:first').text(); // get the id of the clicked row
        var url = '/invoice/findById?id=' + id; // construct the URL for the GET request

        $.get(url, function (invoice, status){
            $('#idEdit').val(invoice.id);
            $('#websiteEdit').val(invoice.website);
            $('#nameEdit').val(invoice.name);
            $('#addressEdit').val(invoice.address);
            $('#stateEdit').val(invoice.stateid);
            $('#countryEdit').val(invoice.countryid);
            $('#cityEdit').val(invoice.city);
            $('#phoneEdit').val(invoice.phone);
            $('#mobileEdit').val(invoice.mobile);
            $('#emailEdit').val(invoice.email);

        });

        $('#editModal').modal('show');
    });

    // $('table #deleteButton').on('click', function (event){
    //     //event.preventDefault();
    //     var id = $(this).data('id');
    //     var url = '/invoice/delete?id=' + id;
    //     $('#confirmDeleteButton').attr('href',url)
    //
    //
    //
    //     $('#deleteModal').modal('show');
    // });

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        //countries/delete/?id=
        var id = $(this).closest('tr').find('th:first').text();
        var url = '/invoice/delete?id=' + id;
        $('#confirmDeleteButton').attr('href',url)


        $('#deleteModal').modal('show');
    });


});