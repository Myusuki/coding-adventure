FILENAME = main.c
EXENAME = L6
TEST = test.c

install:
	cc $(FILENAME) -o $(EXENAME) -O1 -Wall -Wno-missing-braces -w -lSDL2 -lSDL2_image

debug:
	cc -g $(FILENAME) -o $(EXENAME) -O1 -Wall -Wno-missing-braces -w -lSDL2

test:
	cc $(TEST) -o Test -O1 -Wall -Wno-missing-braces -w -lSDL2

clean:
	rm $(EXENAME) 

remove:
	rm Test
