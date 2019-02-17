JUnit ?
-------

-  Framework open source pour Java créé par Kent Beck et Erich
Gamma
- Permettant d’automatiser les tests et de s’assurer que le
programme répond toujours aux besoins
- Basé sur les assertions qui vérifient si les résultats de tests
correspondent aux résultats attendus
- Membre de la famille XUnit (CPPUnit pour C++, CUnit pour C,
PHPUnit pour PHP...)

*Objectif : Trouver un maximum de bugs pour les corriger

Annotations :
-------------

- @BeforeAll : la méthode annotée sera exécutée seulement
avant le premier test
- @AfterAll : la méthode annotée sera exécutée seulement après
le dernier test
- @BeforeEach : la méthode annotée sera exécutée avant chaque
test
- @AfterEach : la méthode annotée sera exécutée après chaque
test

Assert 
------

- assertTrue : permet de vérifier que
la condition fournie en paramètre est vraie
- assertFalse: permet de vérifier que
la condition fournie en paramètre est fausse
- assertEquals : permet de
vérifier l’égalité (sa réciproque est assertNotEquals)
- assertNotNull : permet de vérifier, pour
les paramètres utilisés, qu’une méthode ne retourne pas la valeur
null (sa réciproque est assertNull)


mockito
------
est un framework Java permettant de générer automatiquement des  objets ‘mockés‘. Couplé avec JUnit permet de tester le comportement des objets réels associés à un ou des objets ‘mockés’