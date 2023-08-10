import {GithubUserRepository} from "./GithubUserRepository";

export interface GithubUserDetails {
  username: string,
  avatar: string,
  url: string,
  createdAt: Date
  repos: GithubUserRepository[]
  repoSize: number
}
