
        </div>
        <!-- close col-9 -->
    </div>
    <!-- close row -->
</div>
<!-- close container-fluid -->
<footer class="footer m-4" >
    <hr class="my-5" style="width: 60%; border-top: 2px solid black;">
    <div class="footer-main">
        <div class="row">
            <div class="col-md-5">
                <h3>Introduce</h3>
                <p style="padding-top: 5px;">
                    <b>ME : </b> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
            <div class="col-md-3">
                <h3 class="ml-3 pl-1">Link Contact</h3>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">Cras justo odio</li>
                  <li class="list-group-item">Dapibus ac facilisis in</li>
                  <li class="list-group-item">Morbi leo risus</li>
                  <li class="list-group-item">Porta ac consectetur ac</li>
                  <li class="list-group-item">Vestibulum at eros</li>
                </ul>
            </div>
            <div class="col-md-4">
                <h3 class="ml-3 pl-1">Infomation Contact</h3>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">Cras justo odio</li>
                  <li class="list-group-item">Dapibus ac facilisis in</li>
                  <li class="list-group-item">Morbi leo risus</li>
                  <li class="list-group-item">Porta ac consectetur ac</li>
                  <li class="list-group-item">Vestibulum at eros</li>
                </ul>
            </div>
            <div class="col-md-12 text-center mt-3">
                <b>Copyright &copy; 2021 - ME. All rights reserved. <a href="">Powered by M.THANH</a>
                </b>
            </div>
        </div>
    </div>
</footer>
<!-- for bootstrap and jquery -->
<script type="text/javascript" src="/libs/bootstrap-4.1.3/dist/js/jquery-3.5.1.slim.min.js"></script>
<script type="text/javascript" src="/libs/bootstrap-4.1.3/dist/js/popover.min.js"></script>
<script type="text/javascript" src="/libs/bootstrap-4.1.3/dist/js/bootstrap.min.js"></script>
<script>
    function sureDelete(id) {
        if (confirm("Are you sure you want to delete this data?")){
            location.href = "/Customer?action=deleteCustomer&id="+id;
        }
    }
</script>
</body>

</html>