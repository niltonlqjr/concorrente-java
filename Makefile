cc=javac

target = Concorrente.jar
source_ext = .java
obj_ext = .class
source_dir = aula/concorrente
build_dir = aula/concorrente
main_file = Concorrente

jar: build
	jar cfe $(target) $(build_dir)/$(main_file) $(build_dir)/*.class

run : build
	java $(build_dir)/$(main_file)

build: $(build_dir)/$(main_file)$(obj_ext)

$(main_file)$(obj_ext): $(source_dir)/$(main_file)$(source_ext)
	$(cc) $< -d .

$(build_dir)/%$(obj_ext): $(source_dir)/%$(source_ext)
	$(cc) $< -d .
	
clean:
	rm $(build_dir)/*$(obj_ext) $(target)