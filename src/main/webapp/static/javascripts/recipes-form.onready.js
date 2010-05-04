$(document).ready(function()
{
    // TODO DRY these up!

    $('.add-ingredient').click(function()
    {
        if ($(this).data('count') == null)
        {
            //alert("initializing");
            var input = $('.ingredients li:last input[name!=""]:first')[0];
            var index = parseInt($(input).attr('name').match(/.*?\[(.*?)\].*/)[1]);
            $(this).data('count', index);
        }

        //alert($(this).data('count'));
        var newIngredient = $('.ingredients li:last').clone(true).appendTo($('.ingredients'));
        var newIndex = $(this).data('count') + 1;

        $(this).data('count', newIndex);

        $('input,select', newIngredient).each(function()
        {
            $(this).attr('name', $(this).attr('name').replace(/\[.+?\]/, "[" + newIndex + "]"));
            $(this).attr('value', '');
            //alert($(this).attr('name'));
        });

        //$(newIngredient).ezpz_hint({ hintClass : 'blur' })
        $('input:nth(0)', newIngredient).focus();
    });

    $('.add-step').click(function()
    {
        if ($(this).data('count') == null)
        {
            //alert("initializing");
            var input = $('.steps li:last input[name!=""]:first')[0];
            var index = parseInt($(input).attr('name').match(/.*?\[(.*?)\].*/)[1]);
            $(this).data('count', index);
        }

        //alert($(this).data('count'));

        var newStep = $('.steps li:last').clone(true).appendTo($('.steps'));
        var newIndex = $(this).data('count') + 1;

        $(this).data('count', newIndex);

        $('input', newStep).each(function()
        {
            $(this).attr('name', $(this).attr('name').replace(/\[.+?\]/, "[" + newIndex + "]"));
            $(this).attr('value', '');
            //alert($(this).attr('name'));
        });

        $('input:nth(0)', newStep).focus();
    });

    $('.delete').click(function()
    {
        if ($(this).parent().siblings('li').length > 0)
        {
            $(this).parent().fadeOut(function() { $(this).remove(); });
        }
    });

});