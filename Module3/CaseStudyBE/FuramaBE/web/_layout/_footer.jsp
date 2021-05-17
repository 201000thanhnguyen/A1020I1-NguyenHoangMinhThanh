

</div>
</div>
</div>
<!-- for bootstrap and jquery -->
<script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/jquery-3.5.1.slim.min.js"></script>
<script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/popover.min.js"></script>
<script type="text/javascript" src="/lib/bootstrap-4.1.3/dist/js/bootstrap.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function(){

        window.addEventListener('scroll', function() {
            // img max width 200 px - nav 48px => 132
            if (window.scrollY > 132) {
                document.getElementById("navbar_top").classList.add('fixed-top');
                // add padding top to show content behind navbar
                navbar_height = document.querySelector('.navbar').offsetHeight;
                document.body.style.paddingTop = navbar_height + 'px';
            } else {
                document.getElementById("navbar_top").classList.remove('fixed-top');
                // remove padding top from body
                document.body.style.paddingTop = '0';
            }
        });
    });
</script>
</body>

</html>