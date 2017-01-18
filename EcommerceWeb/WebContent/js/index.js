
        // box-shadow sous le menu lors du scroll
        $(window).on('scroll', function(){
            if($(window).scrollTop() > 0) {
                $('header').addClass('scroll');
            } else {
                $('header').removeClass('scroll');
            }
        });

        //Popup connexion
        $('.signup, .redirectConnexion').on('click', function(e){
            e.preventDefault();
            $('body').addClass('popup-open');
            $('.popup').show();
            $('.popup-inscription').hide();
            $('.popup-connexion').show();
        });

        //Popup inscription
        $('.signin, .redirectInscription').on('click', function(e){
            e.preventDefault();
            $('body').addClass('popup-open');
            $('.popup').show();
            $('.popup-inscription').show();
            $('.popup-connexion').hide();
        });

        //Fermer la popup lors d'un clic en dehors de la popup
        $(document).on('mouseup', function (e) {
            var container = $(".popup-content, #search");
            if (!container.is(e.target) && container.has(e.target).length === 0) {
                container.hide();
                $('.popup').hide();
                $('body').removeClass('popup-open');
                container.find('.step').hide();
                container.find('.step1').show();
                container.find('.error').empty();
            }
        });

        //Affichage de la recherche
        $('#showSearch').on('click', function(e){
            e.preventDefault();
            $('#search').show().focus();
        });

        //Masquage de la recherche
        $('#closeSearch').on('click', function(e){
            e.preventDefault();
            $('#search').hide();
        });

        // Animation ajout au panier
        $('article button').on('click', function(){
            var article = $(this).closest('article');
            var img = article.find('img');
            var imgClone = img.clone().appendTo(article.closest('div'));
            imgClone.addClass('duplicateImg').css('width',img.width());
            imgClone.addClass('duplicateImg').css('height',img.height());
            var top = img.offset().top - $(window).scrollTop();
            imgClone.css('top',top);
            imgClone.css('left',img.offset().left);

            var offset = $('#cart .icon').offset();

            imgClone.animate({
                'width': '15px',
                'height': '15px',
                'left': offset.left + 5,
                'top': offset.top - $(window).scrollTop() - 10
                }, 750, function(){
                imgClone.animate({
                    'top': offset.top - $(window).scrollTop(),
                    'opacity': 0
                    }, 100, function(){
                        imgClone.remove();
                });
            });
        });

        $(function(){
        	
        
        // Gestion du slider
        setInterval(function(){
            widthSmall = $('.slider .slide:eq(0) img').width();
            widthBig = $('.slider .slide:eq(1) img').width();

            $('.slider .slide:eq(0)').animate({
                'margin-left': '-33%'
            }, 1000, function(){
                var slide = $('.slider .slide:eq(0)').clone();
                $('.slider .slide:eq(0)').remove();
                slide.removeAttr('style');
                $('.slider').append(slide[0].outerHTML);
            });

            $('.slider-info .name, .slider-info .prix').animate({
                'opacity': '0'
            }, 500, function(){
                $('.slider-info .name').text($('.slider .slide:eq(2)').attr('data-name'));
                $('.slider-info .prix').text($('.slider .slide:eq(2)').attr('data-prix'));
                $('.slider-info .name, .slider-info .prix').animate({
                    'opacity': '1'
                }, 500);
            });

            $('.slider .slide:eq(0)').animate({
                'margin-left': '-33%'
            }, { duration: 1000, queue: false }, function(){
                var slide = $('.slider .slide:eq(0)').clone();
                $('.slider .slide:eq(0)').remove();
                slide.removeAttr('style');
                $('.slider').append(slide[0].outerHTML);
            });



            $('.slider .slide:eq(1), .slider .slide:eq(3)').animate({
               'opacity': '0.5'
            }, { duration: 1000, queue: false });

            $('.slider .slide:eq(2)').animate({
               'opacity': '1'
            }, { duration: 1000, queue: false });

            $('.slider .slide:eq(2) img').animate({
               'width': widthBig,
               'top': 0
            }, { duration: 1000, queue: false });

            $('.slider .slide:eq(1) img, .slider .slide:eq(3) img').animate({
               'width': widthSmall,
               'top': '200px'
            }, { duration: 1000, queue: false });




        }, 4000);
        });
   