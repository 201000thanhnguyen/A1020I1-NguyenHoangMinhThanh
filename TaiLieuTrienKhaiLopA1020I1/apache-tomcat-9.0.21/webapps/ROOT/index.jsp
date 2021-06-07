<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- use fontawesome -->
    <link rel="stylesheet" href="/lib/bootstrap-4.1.3/dist/fontawesome/falibs/all.css">
    <!-- use bootstrap -->
    <link rel="stylesheet" href="/lib/bootstrap-4.1.3/dist/css/bootstrap.min.css">
    <!-- use data table bootstrap -->
    <link rel="stylesheet" href="/lib/bootstrap-4.1.3/dist/css/dataTables.bootstrap4.min.css">
    <!-- use bootstrap icon -->
    <link rel="stylesheet" href="/lib/bootstrap-4.1.3/dist/bicons/bootstrap-icons-1.4.1/bootstrap-icons.css">
    <!-- for bootstrap and jquery -->
    <script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/jquery-3.5.1.slim.min.js"></script>
    <script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/popover.min.js"></script>
    <!-- use jQuery Ajax -->
    <script type="text/javascript" src="/lib/jQuery/node_modules/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="/lib/jQuery/node_modules/jquery/dist/sweetalert.min.js"></script>
    <!-- default of bootstrap -->
    <script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/bootstrap.min.js"></script>
    <!-- use validate of jquery -->
    <script type="text/javascript" src="/lib/jQuery/node_modules/jquery/dist/jquery.validate.min.js"></script>
    <!-- use angular -->
    <script type="text/javascript" src="/lib/angular-1.8.2/angular.min.js"></script>

    
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="card m-3">
                <div class="card-header">
                    <a href="#" class="text-primary float-left my-1">Books</a>
                    <a href="#" id="addBook" class="bg-primary text-white rounded float-left mx-2 px-3 py-1" 
                            data-toggle="modal" data-target="#showAddModal">Add</a>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-responsive w-100 d-block d-md-table" id="tableBook">
                        <thead>
                        <tr>
                            <th>action</th>
                            <th>book id</th>
                            <th>book name</th>
                            <th>book date create</th>
                        </tr>
                        </thead>
                        <tbody id="tbodyBook">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-12" id="modalOfBook">

        </div>
    </div>
</div>

<!-- for data tables -->
<script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        loadListBook();
    });

    function loadListBook () {
        $.ajax({
            url: window.location.origin + "/Book",
            type: "get",
            contentType: "application/json; charset=utf-8",
            async: false,
            success: function (data) {
                if (data.code == 200) {
                    console.log(data);
                    $('#tbodyBook').empty();
                    $.each(data.listBook, function (k, v) {
                        let tr = '<tr id="'+v.bookId+'">\n' +
                            '                                <td>\n' +
                            '                                    <div class="btn-group">\n' +
                            '                                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">\n' +
                            '                                            Action\n' +
                            '                                        </button>\n' +
                            '                                        <div class="dropdown-menu">\n' +
                            '                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#detail' + v.bookId + '">Detail</a>\n' +
                            '                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#edit' + v.bookId + '">Edit</a>\n' +
                            '                                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete' + v.bookId + '">Delete</a>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                </td>\n' +
                            '                                <td>\n' +
                            '                                    ' + v.bookId + '\n' +
                            '                                </td>\n' +
                            '                                <td>\n' +
                            '                                    ' + v.bookName + '\n' +
                            '                                </td>\n' +
                            '                                <td>\n' +
                            '                                    ' + v.bookCreateDate + '\n' +
                            '                                </td>\n' +
                            '                            </tr>';
                        $('#tableBook').append(tr);

                        let listModal = '' +
                            '<div class="modal fade" id="detail' + v.bookId + '" tabindex="-1" role="dialog" aria-labelledby="detail-' + v.bookId + '" aria-hidden="true">\n' +
                            '  <div class="modal-dialog modal-dialog-scrollable" role="document">\n' +
                            '    <div class="modal-content">\n' +
                            '      <div class="modal-header">\n' +
                            '        <h5 class="modal-title" id="detail-' + v.bookId + '">Modal title</h5>\n' +
                            '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                            '          <span aria-hidden="true">&times;</span>\n' +
                            '        </button>\n' +
                            '      </div>\n' +
                            '      <div class="modal-body">\n' +
                            '        <form>\n' +
                            '           <div class="form-row">\n' +
                            '               <div class="form-group col-md-12">\n' +
                            '                   <label for="detailBookName' + v.bookName + '">Book Name</label>\n' +
                            '                   <input type="text" class="form-control" id="detailBookName' + v.bookName + '" value="' + v.bookName + '" readonly>\n' +
                            '               </div>\n' +
                            '               <div class="form-group col-md-12">\n' +
                            '                   <label for="detailBookCreateDate' + v.bookName + '">Book Create</label>\n' +
                            '                   <input type="date" class="form-control" id="detailBookCreateDate' + v.bookName + '" value="' + v.bookCreateDate + '" disabled>\n' +
                            '               </div>\n' +
                            '           </div>\n' +
                            '        </form>\n' +
                            '      </div>\n' +
                            '      <div class="modal-footer">\n' +
                            '        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>\n' +
                            '      </div>\n' +
                            '    </div>\n' +
                            '  </div>\n' +
                            '</div>' +
                            '<div class="modal fade" id="edit' + v.bookId + '" tabindex="-1" role="dialog" aria-labelledby="edit-' + v.bookId + '" aria-hidden="true">\n' +
                            '  <div class="modal-dialog modal-dialog-scrollable" role="document">\n' +
                            '    <div class="modal-content">\n' +
                            '      <div class="modal-header">\n' +
                            '        <h5 class="modal-title" id="edit-' + v.bookId + '">Modal title</h5>\n' +
                            '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                            '          <span aria-hidden="true">&times;</span>\n' +
                            '        </button>\n' +
                            '      </div>\n' +
                            '      <div class="modal-body">\n' +
                            '        <form>\n' +
                            '           <div class="form-row">\n' +
                            '               <div class="form-group col-md-12">\n' +
                            '                   <label for="editBookName' + v.bookName + '">Book Name</label>\n' +
                            '                   <input type="text" class="form-control" id="editBookName' + v.bookName + '" value="' + v.bookName + '">\n' +
                            '               </div>\n' +
                            '               <div class="form-group col-md-12">\n' +
                            '                   <label for="editBookCreateDate' + v.bookName + '">Book Create</label>\n' +
                            '                   <input type="date" class="form-control" id="editBookCreateDate' + v.bookName + '" value="' + v.bookCreateDate + '">\n' +
                            '               </div>\n' +
                            '           </div>\n' +
                            '        </form>\n' +
                            '      </div>\n' +
                            '      <div class="modal-footer">\n' +
                            '        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>\n' +
                            '        <button type="button" class="btn btn-success" id="saveEditBook">Save changes</button>\n' +
                            '      </div>\n' +
                            '    </div>\n' +
                            '  </div>\n' +
                            '</div>' +
                            '<div class="modal fade" id="delete' + v.bookId + '" tabindex="-1" role="dialog" aria-labelledby="delete-' + v.bookId + '" aria-hidden="true">\n' +
                            '  <div class="modal-dialog modal-dialog-scrollable" role="document">\n' +
                            '    <div class="modal-content">\n' +
                            '      <div class="modal-header">\n' +
                            '        <h5 class="modal-title" id="delete-' + v.bookId + '">Modal title</h5>\n' +
                            '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                            '          <span aria-hidden="true">&times;</span>\n' +
                            '        </button>\n' +
                            '      </div>\n' +
                            '      <div class="modal-body">\n' +
                            '        <h4 class="mb-3">are you sure delete data : </h4>\n' +
                            '        <p>Book Id : ' + v.bookId + '</p>\n' +
                            '        <p>Book Name : ' + v.bookName + '</p>\n' +
                            '        <p>Book Create Date : ' + v.bookCreateDate + '</p>\n' +
                            '      </div>\n' +
                            '      <div id="'+v.bookId+'" class="modal-footer">\n' +
                            '        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>\n' +
                            '        <button type="button" class="btn btn-success" id="saveDeleteBook">Save changes</button>\n' +
                            '      </div>\n' +
                            '    </div>\n' +
                            '  </div>\n' +
                            '</div>';
                        $('#modalOfBook').append(listModal);
                    })
                } else {
                    console.log(data.msg);
                }
            }
        });
        let modalAddBook = '' +
            '<div class="modal fade" id="showAddModal" tabindex="-1" role="dialog" aria-labelledby="showAddModalTitle" aria-hidden="true">\n' +
            '  <div class="modal-dialog modal-dialog-scrollable" role="document">\n' +
            '    <div class="modal-content">\n' +
            '      <div class="modal-header">\n' +
            '        <h5 class="modal-title" id="showAddModalTitle">Modal title</h5>\n' +
            '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
            '          <span aria-hidden="true">&times;</span>\n' +
            '        </button>\n' +
            '      </div>\n' +
            '      <div class="modal-body">\n' +
            '        <form>\n' +
            '          <div class="form-group">\n' +
            '            <label for="inpBookName">Book Name</label>\n' +
            '            <input type="text" class="form-control" id="inpBookName">\n' +
            '          </div>\n' +
            '          <div class="form-group">\n' +
            '            <label for="inpBookCreateDate">Book Create Date</label>\n' +
            '            <input type="date" class="form-control" id="inpBookCreateDate">\n' +
            '          </div>\n' +
            '        </form>\n' +
            '      </div>\n' +
            '      <div class="modal-footer">\n' +
            '        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>\n' +
            '        <button type="button" id="saveAddBook" class="btn btn-success">Save changes</button>\n' +
            '      </div>\n' +
            '    </div>\n' +
            '  </div>\n' +
            '</div>';
        $('#modalOfBook').append(modalAddBook);
        $('#tableBook').DataTable();
    };

    $(document).on('click','button[id="saveDeleteBook"]',function () {
        let bookId = $(this).parent('div').attr('id');
        $.ajax({
            url: window.location.origin + '/Book?action=deleteBook',
            type: 'get',
            data: {
                bookId: "4"
            },
            success: function (data) {
                    if (data.code == 200) {
                        swal({
                            title: "Message",
                            text: data.msg,
                            icon: "success",
                            button: "Close",
                        })
                    }else {
                        swal({
                            title: "Error",
                            text: "check code ajax or code service!",
                            icon: "error",
                            button: "Close",
                        })
                    }
                },
            error: function () {
                    swal({
                        title: "Message",
                        text: "error syntax ?",
                        icon: "error",
                        button: "Close",
                    });
                }
            });
            $('.modal').modal('hide');
            loadListBook();
        });

    $(document).on('click','button[id="saveAddBook"]',function () {
        let obj = {
            bookName: $('#inpBookName').val().trim(),
            bookCreateDate: $('#inpBookCreateDate').val().trim()
        };
        $.ajax({
            url: window.location.origin + "/Book?action=addBook",
            type: 'post',
            data: obj,
            success: function (data) {
                swal({
                    title: "message",
                    text: data.msg,
                    icon: "success",
                    button: "close"
                });
            },
            error: function (data) {
                swal({
                    title: "message",
                    text: data.msg,
                    icon: "error",
                    button: "close"
                });
            }
        });
        $('.modal').modal('hide');
        loadListBook();
    });
</script>
</body>

</html>
