# Comandos útiles de docker

Listado de contenedores:

```bash
$ docker ps
```

Parar un contenedor:

```bash
$ docker stop [contenedor]
```

Borrar un contenedor:

```bash
$ docker rm [contenedor]
```

Listado de imágenes:

```bash
$ docker image ls
```

Borrar una imagen:

```bash
$ docker rmi [imagen]
```

Listado de volúmenes:

```bash
$ docker volume ls
```

Borrar todos los volúmenes que no estén usados por ningún contenedor:

```bash
$ docker volume prune
```

Borrar un volumen concreto:

```bash
$ docker volume rm [volumen]
```
