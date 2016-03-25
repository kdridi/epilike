namespace java eu.epitech.epilike.thrift

struct LoginForm {
  1: string login,
  2: string password
}

service EpiLikeService {
  bool login(1:LoginForm form)
}