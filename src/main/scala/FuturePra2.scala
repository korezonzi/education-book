import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}
case class Organization(
  id: Long,
  name: String,
  email: String
)
//法人所有(Organization)の施設情報
case class Branch(
  id:             Long,
  organizationId: Long,
  name:           String
)

object Database {
  def getBranchById(branchId: Long): Future[Branch] = {
    Future.successful(Branch(
      id             = 1,
      organizationId = 1,
      name           = "nextbeat保育園"
    ))
  }

  def getOrganizationById(organizationId: Long): Future[Organization] = {
    Future.successful(Organization(
      id            = 1,
      name          = "株式会社nextbeat",
      email         = "hoge@nextbeat.net"
    ))
  }
}

object FuturePra2 {
  def main(args: Array[String]): Unit = {
    //println(getOrganizationNameByBranchId_2(1))
    //println(getOrganizationNameByBranchId_2(2))
    println(getOrganizationNameByBranchId_4(1))
    //println(getOrganizationNameByBranchId_4(2))
    //println(getOrganizationNameByBranchId_4_2(1))
  }

  def getOrganizationNameByBranchId(branchId: Long) = {
    val branchFuture: Future[Branch] = Database.getBranchById(branchId)
    val organizationFuture: Future[Organization] = Database.getOrganizationById(branchId)
    val resFuture = for{
      bid <- branchFuture.map(_.id)
      oid <- organizationFuture.map(_.id)
      res <- if(bid == oid) organizationFuture.map(_.name) else organizationFuture.map(x => "not found")
    } yield res
    Await.ready(resFuture, Duration.Inf)
  }

  def getOrganizationNameByBranchId_2(branchId: Long) = {
    val oNameFuture = for {
      branch <- Database.getBranchById(branchId)
      organization <- Database.getOrganizationById(branch.organizationId)
    } yield organization.name
    //Await.ready(oNameFuture, Duration.Inf)
    oNameFuture.onComplete {
      case Success(value)     => println(value)
      case Failure(exception) => println(exception.getMessage)
    }
  }

  //よくない
  def getOrganizationNameByBranchId_3(branchId: Long) = {
    val branchInfo: Try[Branch]    = Database.getBranchById(branchId).value.get
    // Success(Branch(1,1,nextbeat保育園))
    val orgInfo: Try[Organization] = Database.getOrganizationById(branchId).value.get
    //Success(Organization(1,株式会社nextbeat,nextbeat.net))
    val nurseryName: Try[String] = branchInfo.flatMap(b =>
      orgInfo.flatMap(o =>
        o.id match {
          case b.id => Success(b.name)
          case _    => Failure(throw new NoSuchElementException)
        }
      )
    )
    //nurseryName  //Success(Success(nextbeat保育園))
    nurseryName.get
  }

  def getOrganizationNameByBranchId_4(branchId: Long) = {
    val result: Future[String] = for {
      branch <- Database.getBranchById(branchId)
      org    <- Database.getOrganizationById(branch.id)
    } yield org.name
    result.foreach(println(_))
  }

  def getOrganizationNameByBranchId_4_2(branchId: Long) = {
    val result: Future[String] = for {
      branch <- Database.getBranchById(branchId)
      org    <- Database.getOrganizationById(branch.id)
    } yield org.name
    Await.ready(result, Duration.Inf).onComplete{
      case Success(x) => println(x)
      case Failure(e) => println(e)
    }
  }
}