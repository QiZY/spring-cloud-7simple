namespace java com.seven.cloud.thrift.service

struct UserDto {
  1: i32 id
  2: string username
}

service UserService {
  UserDto getUser()
}