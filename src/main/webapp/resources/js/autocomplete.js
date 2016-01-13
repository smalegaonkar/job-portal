
  $(function() {
    var availableTags = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme",
	  "Tom_Cruise",
	  "James_Bond",
	  "Brad Pitt",
	  "Northeastern_University",
	  "Jeniffer Lawrence",
	  "Fenway"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  });
